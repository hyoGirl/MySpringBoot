package com.rabbitmq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rabbitmq.direct.DirectAPP;
import com.rabbitmq.direct.send.HelloSender;

@SpringBootTest(classes=DirectAPP.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQSend {
    
    @Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }
}