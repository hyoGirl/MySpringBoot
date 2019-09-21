package com.xulei.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 10:12
 * @Version 1.0
 */
@Configuration
public class MailMQConfig {



    // 发送邮件
    public static final String MAIL_QUEUE_NAME = "mail.queue";
    public static final String MAIL_EXCHANGE_NAME = "mail.exchange";
    public static final String MAIL_ROUTING_KEY_NAME = "mail.routing.key";


    //消息队列
    @Bean
    public Queue mailQueue() {

        return new Queue(MAIL_QUEUE_NAME,true);
    }

    //邮件交换器
    @Bean
    public DirectExchange mailExchange() {

        return new DirectExchange(MAIL_EXCHANGE_NAME, true, false);
    }

    // 交换器与路由绑定
    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MAIL_ROUTING_KEY_NAME);
    }




}
