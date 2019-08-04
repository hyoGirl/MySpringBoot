package com.redis.lua;

import redis.clients.jedis.Jedis;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/4 22:11
 * @Version 1.0
 */
public class RedisLuaData {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1",6379);


//         String SCRIPT =
//                "local t1 = redis.call('hgetall',KEYS[1]);" + "\n" +
//                        "if type(t1) == 'table' then" + "\n" +
//                        "return t1;" + "\n" +
//                        "end;" + "\n" ;
        long score1=System.currentTimeMillis()+2*1000;
        jedis.zadd("delay002",score1,"test001");
        long score2=System.currentTimeMillis()+3*1000;
        jedis.zadd("delay002",score2,"test002");

    }
}
