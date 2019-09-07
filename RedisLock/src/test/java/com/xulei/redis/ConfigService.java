package com.xulei.redis;

import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.LocalTime;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/16 23:51
 * @Version 1.0
 */
public class ConfigService {

    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool= new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    int num=10;

    private RedisLock01 redisLock01=new RedisLock01(pool);

    public   void kill() {
        String id = redisLock01.addLock("resource", 5000, 1000);
        if(!StringUtils.isEmpty(id)){
            if(num<=0){
                System.out.println(LocalTime.now()+"库存已经完了");
                redisLock01.releaseLock("resource",id);
                System.out.println(LocalTime.now()+" "+Thread.currentThread().getName() + "--> 释放了锁");
                return;
            }else{
                /**
                 *
                 * 还存在一个问题： 处理的业务时间大于过期时间了怎么办？
                 * 目前只解决了误删除的问题，具体时间问题还没解决？
                 * 如果业务处理过程中出现了异常怎么办？  这个就是为啥要设置过期时间的原因，防止出错后出现问题
                 *
                 */
                System.out.println(LocalTime.now()+" "+Thread.currentThread().getName() + "获得了锁 .锁ID： "+ id +"--> 当前仓库持有量为："+ (--num));
                redisLock01.releaseLock("resource",id);
            }
        }
    }
}
