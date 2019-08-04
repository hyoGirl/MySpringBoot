package com.redis.delay.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.redis.delay.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
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

    @Async
    public void  conumer(String queueKey){

        while (true){
            ZSetOperations zSet = redisTemplate.opsForZSet();
            Set<String> values = zSet.rangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String next = values.iterator().next();

            if (zSet.remove(queueKey, next) > 0){
                Msg msg = JSONObject.parseObject(next, Msg.class);

                System.out.println("延迟处理的的时间为： " + LocalTime.now()+"-->"+System.currentTimeMillis());
                System.out.println(msg);
            }
        }


    }
}
