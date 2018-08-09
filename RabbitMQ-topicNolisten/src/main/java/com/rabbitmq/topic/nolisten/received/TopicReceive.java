package com.rabbitmq.topic.nolisten.received;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive {
	
	@RabbitListener(queues="topicNoListen.s1")    //监听器监听指定的Queue
    public void process1(String str) {  
		
        System.out.println("data.s1:"+str);
    }
    @RabbitListener(queues="topicNoListen.s2")    //监听器监听指定的Queue
    public void process2(String str) {
    	
        System.out.println("data.s2:"+str);
    }
}
