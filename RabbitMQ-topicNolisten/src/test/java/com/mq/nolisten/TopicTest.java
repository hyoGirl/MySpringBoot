package com.mq.nolisten;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rabbitmq.topic.nolisten.NoListenApp;
import com.rabbitmq.topic.nolisten.send.TopicSend;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=NoListenApp.class)
public class TopicTest {


    @Autowired
    private TopicSend helloSender;

    @Test
    public void testSend(){


       helloSender.send();

    }

}
