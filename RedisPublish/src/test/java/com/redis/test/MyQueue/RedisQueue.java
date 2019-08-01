package com.redis.test.MyQueue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/1 21:33
 * @Version 1.0
 */
public class RedisQueue {


    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //1: 模拟立刻关注后打印数据
        System.out.println("================这个是立刻关注后的打印==========谢谢关注=============");


        //2：模拟发送消息到延迟队列中

        Message message = new Message();

        message.setId(UUID.randomUUID().toString());

        message.setBody("这是延迟队列里面的第一条消息");

        // 模拟延迟2秒
        int delayTime = 2;

        message.setDelay(delayTime);

        sendMsgDely(message, jedis);

        consumeDelay(jedis);

    }

    /**
     * 处理延迟时间
     *
     * @param jedis
     */
    private static void consumeDelay(Jedis jedis) {

        while (true) {
            // 最小  最大  下标  几个？
            Set<String> delaySet = jedis.zrangeByScore("delay", 0, System.currentTimeMillis(), 0, 1);

            if (delaySet.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            String next = delaySet.iterator().next();
            Long delay = jedis.zrem("delay", next);
            if (delay > 0) {
                Message message = JSONObject.parseObject(next, Message.class);
                System.out.println("延迟处理的的时间为： " + LocalTime.now()+"-->"+System.currentTimeMillis());
                System.out.println(message);
            }
            break;
        }

    }

    /**
     * 发送任务到延迟队列中
     *
     * @param message
     * @param jedis
     */
    private static void sendMsgDely(Message message, Jedis jedis) {
        long delay = message.getDelay();
        long score = System.currentTimeMillis() + delay * 1000;
        System.out.println("放入前的时间为： " + LocalTime.now()+"-->"+score);
        jedis.zadd("delay", score, JSON.toJSONString(message));
    }
}


//https://blog.csdn.net/qpatience/article/details/90718133