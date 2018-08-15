package com.rabbitmq.topic2.Receive;

import com.rabbitmq.topic2.Listen.MyReceiveListener;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2018/7/16 0016 17:07
 * @Description:
 */
@Component
public class HelloReceive {


    @Autowired
    @Qualifier("queue")
    private  Queue queue;

    @Autowired
    @Qualifier("secondQueue")
    private  Queue secondQueue;

    @Autowired
    private MyReceiveListener myReceiveListener;


    //绑定第一个队列
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainerQueue(ConnectionFactory connectionFactory){

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);

        container.setQueues(queue);

        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        container.setMessageListener(myReceiveListener);

        return container;

    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainersecondQueue(ConnectionFactory connectionFactory){

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);

        container.setQueues(secondQueue);

        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        container.setMessageListener(myReceiveListener);

        return container;

    }



}
