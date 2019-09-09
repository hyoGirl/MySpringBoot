package com.rabbitmq.test;

import com.rabbitmq.topic.TopicApp;
import com.rabbitmq.topic.send.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Administrator
 * @Date: 2018/7/16 0016 09:55
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TopicApp.class)
public class TestTopicSend {


    @Autowired
    private HelloSender helloSender;

    @Test
    public void testSend(){


            for(int i=0;i<10;i++){
                helloSender.send("topic.msg",((int)Math.random()*(10-1)+1)+" ");
            }

//        helloSender.producer("topic.message","dddd");

    }

}
