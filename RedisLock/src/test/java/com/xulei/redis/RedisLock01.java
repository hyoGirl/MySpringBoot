package com.xulei.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalTime;
import java.util.UUID;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/15 22:31
 * @Version 1.0
 */
public class RedisLock01 {

    /**
     * 使用lua脚本来解决匹配redis和删除redis的key  的原子操作
     */
    private final JedisPool jedisPool;

    public RedisLock01(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    /**
     *
     * 流程：  理想场景下：服务A 获取锁，执行完毕后，删除锁。
     *
     *
     * 1: 服务A假如挂掉后，不能一直持有锁，需要释放锁。为此需要设置一个过期时间
     *    要保证设置过期时间和设置锁具有原子性
     *
     * 2： 要保证 A服务过期时间要大于业务时间?  因为到了过期时间后，A服务的锁被释放了，但是A服务还在进行
     *     此时B服务获取了锁。 A服务在执行完毕后，会去删除锁，结果这个锁被B获取着，结果A删除了B的锁
     *
     *  解决方案： 设置锁的时候，还增加一个随机数目，这样在删除的时候，先匹配随机数目是否一致，然后再删除Key
     *           这样就能保证当前线程占有的锁，就不会被其他线程释放 ?  其他线程就会去释放自己的锁了
     *
     *
     * 3： 获取锁，并且释放锁，这个不是一个原子操作，必须引入lua脚本来完成。或者是使用redis的事务来实现
     */

    /**
     * 加锁
     *
     * @param key
     * @param sleepMillis    上锁后的超时时间
     * @param acquireTimeout 获取锁的超时时间。就是多少时间内持续获取锁
     * @return
     */
    public String addLock(String key, long sleepMillis, long acquireTimeout) {
        String retIdentifier = null;
        Jedis conn = null;
        try {
            conn = jedisPool.getResource();
            //生成一个随机数目
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + key;
            // 超时时间，上锁后超过此时间则自动释放锁`
            int lockExpire = (int) (sleepMillis / 1000);
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            // 超时获取锁 --》可以改成尝试多少次来获取
            while (System.currentTimeMillis() < end) {
                //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
                /**
                 * EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
                   PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
                   NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
                   XX ：只在键已经存在时，才对键进行设置操作。
                 */

                String result = conn.set(lockKey,identifier,"NX", "PX", lockExpire);

                if("OK".equals(result)){
                    System.out.println(Thread.currentThread().getName() + "加锁成功!");
                    retIdentifier = identifier;
                    return retIdentifier;
                }


                /**
                 * 为了避免一直获取锁增大redis压力，线程睡觉几秒
                 */
                try {
                    Thread.sleep(10);
                    System.out.println("线程id:"+Thread.currentThread().getId() + "获取锁失败，休眠10毫秒!时间:"+ LocalTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retIdentifier;

    }

    /**
     * 释放锁
     *
     * @param lockName
     * @param identifier
     * @return
     */
    public void releaseLock(String lockName, String identifier) {

        /**
         *
         * 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
         *
         *  解锁操作包含三步操作：获取值、判断和删除锁 多线程下会出现错误
         *  这段Lua脚本在执行的时候要把的Value作为ARGV[1]的值传进去，把Key作为KEYS[1]的值传进去。现在来看看解锁的java代码
         *
         */

        Jedis conn = null;
        try {
            conn = jedisPool.getResource();
            String checkAndDelScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
           conn.eval(checkAndDelScript, 1, lockName, identifier);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

}
