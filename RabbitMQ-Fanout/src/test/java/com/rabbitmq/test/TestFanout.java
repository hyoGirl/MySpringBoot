package com.rabbitmq.test;

import com.rabbitmq.fanout.FanoutApp;
import com.rabbitmq.fanout.send.HelloSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FanoutApp.class)
public class TestFanout {



    @Autowired
    private HelloSend helloSend;

    @Test
    public void testSend(){

        helloSend.send();

    }



}
