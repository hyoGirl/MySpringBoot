package com.xulei.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Binding;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/9 21:24
 * @Version 1.0
 */
@Configuration
@Slf4j
public class MQConfig {

    // 第一个正常消费的队列
    public static final String MSG_EXCHANGE_NAME = "msg02.exchange";
    public static final String MSG_QUEUE_NAME = "msg02.queue";
    public static final String MSG_ROUTING_KEY_NAME = "msg02.routing.key";

    // 第二个延迟消费的队列

    public static final String TTL_EXCHANGE_NAME = "msg02.exchange.ttl";
    public static final String TTL_QUEUE_NAME = "msg02.queue.ttl";
    public static final String TTL_ROUTING_KEY_NAME = "msg02.ttl.routing.key";



    // 配置第一个交换器
    @Bean
    DirectExchange msgDirectExchange(){
        Exchange build = ExchangeBuilder.directExchange(MSG_EXCHANGE_NAME).durable(true).build();
        return (DirectExchange) build;
    }

    // 配置第一个消息队列
    @Bean
    public Queue  msgQeue(){
        return new Queue(MSG_QUEUE_NAME);
    }

    // 配置交换器和 路由绑定 以及消息队列绑定
    @Bean
    public Binding msgBindng(){
        return BindingBuilder
                .bind(msgQeue())
                .to(msgDirectExchange())
                .with(MSG_ROUTING_KEY_NAME);
    }


    // 配置TTL交换器
    @Bean
    DirectExchange ttlDirectExchange(){
        Exchange build = ExchangeBuilder.directExchange(TTL_EXCHANGE_NAME).durable(true).build();
        return (DirectExchange) build;
    }


    // 配置TTL消息队列
    @Bean
    public Queue  ttlQueue(){
        return QueueBuilder.durable(TTL_QUEUE_NAME)
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange",MSG_EXCHANGE_NAME)
                // 配置到期后转发到那个路由建上
                .withArgument("x-dead-letter-routing-key",MSG_ROUTING_KEY_NAME)
                .build();
    }


    // 配置TTL交换器  路由key  以及消息队列 整合
    @Bean
    public  Binding ttlBinding(){
        return BindingBuilder
                .bind(ttlQueue())
                .to(ttlDirectExchange())
                .with(TTL_ROUTING_KEY_NAME);

    }







}
