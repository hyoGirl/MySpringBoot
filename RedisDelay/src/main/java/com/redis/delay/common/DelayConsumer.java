package com.redis.delay.common;

import com.alibaba.fastjson.JSONObject;
import com.redis.delay.vo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/4 11:40
 * @Version 1.0
 */
@Component
public class DelayConsumer {

    @Autowired
    RedisTemplate redisTemplate;


//    @Bean
//    public RedisScript<List> delayQueueScript() {
//        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
//        //防止其他rest层无法引用资源
//        redisScript.setScriptText("local key = KEYS[1]\n" +
//                "local confirmKey = KEYS[2]\n" +
//                "local score = ARGV[1]\n" +
//                "local limitNum = ARGV[2]\n" +
//                "local result ={}\n" +
//                "local list =redis.call('ZRANGEBYSCORE',key,0,score,'limit',0,limitNum)\n" +
//                "for index,value in ipairs(list) do\n" +
//                "    result[index]=value\n" +
//                "    redis.call('SADD',confirmKey,value)\n" +
//                "    redis.call('ZREM',key,value)\n" +
//                "end\n" +
//                "return list");
//        //redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/getDelayQueue.lua")));
//        redisScript.setResultType(List.class);
//        return redisScript;
//    }

    @Async
    public void  conumer(String queueKey){

//        while (true){
//            ZSetOperations zSet = redisTemplate.opsForZSet();
//            Set<String> values = zSet.rangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
//            if (values.isEmpty()){
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    break;
//                }
//                continue;
//            }
//            String next = values.iterator().next();
//
//            if (zSet.remove(queueKey, next) > 0){
//                Msg msg = JSONObject.parseObject(next, Msg.class);
//
//                System.out.println("延迟处理的的时间为： " + LocalTime.now()+"-->"+System.currentTimeMillis());
//                System.out.println(msg);
//            }
//        }



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

        List<String> keys=new ArrayList<>();
        keys.add("delay002");


        List<String> args2=new ArrayList<>();
        args2.add(System.currentTimeMillis()+"");
        args2.add("1");


//            DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
//            redisScript.setScriptText(scripts);
//            redisScript.setResultType(String.class);
//
//            String eval =(String) redisTemplate.execute(redisScript, keys, args2);

        Jedis jedis = new Jedis("127.0.0.1",6379);

        Object   eval =jedis.eval(scripts,keys,args2);

        System.out.println(eval);

        while (true){
            eval =jedis.eval(scripts,keys,args2);
            if (eval==null){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println(eval);
//            Msg msg = JSONObject.parseObject(eval.toString(), Msg.class);
            System.out.println("延迟处理的的时间为： " + LocalTime.now()+"-->"+System.currentTimeMillis());
//            System.out.println(msg);
        }

//            Msg msg = JSONObject.parseObject(eval.toString(), Msg.class);
//            System.out.println("延迟处理的的时间为： " + LocalTime.now()+"-->"+System.currentTimeMillis());
//            System.out.println(msg);


    }
}
