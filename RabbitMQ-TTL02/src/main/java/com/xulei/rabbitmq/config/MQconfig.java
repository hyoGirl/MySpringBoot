package com.xulei.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/14 21:41
 * @Version 1.0
 */
@Configuration
public class MQconfig {



    // 正常的队列，时间到了后，转到dlx-exchange的交换机上
    @Bean
    public Queue normalQueue(){
        Map<String,Object> map=new HashMap<>();
        map.put("x-dead-letter-exchange","dlx-exchange");
        map.put("x-dead-letter-routing-key","dlx-routing-key");
        return new Queue("queue.normal",true,false,false,map);
    }

    // 正常的交换器
    @Bean
    public DirectExchange normalExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange("normal.exchange").durable(true).build();
    }


    //创建基本交换机+基本路由 -> 死信队列 的绑定
    @Bean
    public Binding normalBinding(){
        return BindingBuilder.bind(normalQueue()).to(normalExchange()).with("normal.key");
    }


    // dlx的队列
    @Bean
    public Queue dlxQueue(){
        return  new Queue("queue.dlx",true);
    }

    //dlx的交换器
    @Bean
    public  DirectExchange dlxExchange(){
        Exchange build = ExchangeBuilder.directExchange("dlx-exchange").durable(true).build();
        return (DirectExchange) build;
    }

    @Bean
    public Binding dlxBinding(){
       return  BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with("dlx-routing-key");
    }

}
