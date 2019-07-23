package com.redis.publish.publish;

import com.redis.publish.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 19:21
 * @Description:
 */
@Component
public class Publisher {


    @Autowired
    RedisTemplate redisTemplate;


    public void pushMessage(String topic, Message message) {
        redisTemplate.convertAndSend(topic,message);

    }
}
