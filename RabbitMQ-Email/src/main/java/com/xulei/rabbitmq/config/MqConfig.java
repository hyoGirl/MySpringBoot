package com.xulei.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {
     @Bean
     public Queue queue() {
          return new Queue("queue");
     }
}