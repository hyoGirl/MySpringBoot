package com.redis.test.lua;

import redis.clients.jedis.Jedis;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/4 14:34
 * @Version 1.0
 */
public class RedisLua {


    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1",6379);


//         String SCRIPT =
//                "local t1 = redis.call('hgetall',KEYS[1]);" + "\n" +
//                        "if type(t1) == 'table' then" + "\n" +
//                        "return t1;" + "\n" +
//                        "end;" + "\n" ;
//        long score1=System.currentTimeMillis()+2*1000;
//        jedis.zadd("delay002",score1,"test001");
//        long score2=System.currentTimeMillis()+3*1000;
//        jedis.zadd("delay002",score2,"test002");




        List<String> keys=new ArrayList<>();
        keys.add("delay002");


        List<String> args2=new ArrayList<>();
        args2.add(System.currentTimeMillis()+"");
        args2.add("1");

         String scripts =
                "local key= KEYS[1]" + "\n" +
                "local score = ARGV[1]" + "\n" +
                "local limitNum = ARGV[2]" + "\n" +
                "local value = ''" + "\n" +
                "local result = {}" + "\n" +
                "local myKeyList = redis.call('ZRANGEBYSCORE',key,0,score,'limit',0,limitNum)" + "\n" +
                "for index,value in pairs(myKeyList)" + "\n" +
                "do" + "\n" +
                "   result[index]=value" + "\n" +
                "   if( redis.call('ZREM',key,value)>0 ) then" + "\n" +
                "   return value" + "\n" +
                "   end" + "\n" +
                "end" + "\n" ;

         //调试语句
//                "return myKeyList" + "\n" ;

        Object eval = jedis.eval(scripts,keys,args2);
        System.out.println(eval);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
