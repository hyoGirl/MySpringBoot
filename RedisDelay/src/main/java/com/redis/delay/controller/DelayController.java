package com.redis.delay.controller;

import com.alibaba.fastjson.JSON;
import com.redis.delay.vo.Msg;
import com.redis.delay.common.DelayConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/4 11:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/delay")
public class DelayController {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    DelayConsumer delayConsumer;


    @GetMapping("/test")
    public  String testDelay(){
        for (int i = 0; i < 5; i++) {
            delay(i);
        }
//        delay(1);
        delayConsumer.conumer("delay002");
        return "添加到延迟队列中了";

    }


    /**
     *
     * 如果延迟时间很短，会存在BUG。。比如1秒。因为排序和删除不是原子性操作
     * @param i
     */
    private void delay(int i) {

        Msg msg=new Msg();

        msg.setId(UUID.randomUUID().toString());
        msg.setMsg("这是延迟队列里面的第【"+ i+" 】条消息");

        long score=System.currentTimeMillis()+(i+1)*1000;

        String data = JSON.toJSONString(msg);

        redisTemplate.opsForZSet().add("delay002",data,score);

    }


}
