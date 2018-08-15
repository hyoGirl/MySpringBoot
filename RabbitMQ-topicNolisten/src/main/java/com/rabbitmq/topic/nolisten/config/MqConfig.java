package com.rabbitmq.topic.nolisten.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

        @Bean(name="s1")
        public Queue queueMessage() {
            return new Queue("topicNoListen.s1");
        }

        @Bean(name="s2")
        public Queue queueMessages() {
            return new Queue("topicNoListen.s2");
        }

        @Bean
        public TopicExchange exchange() {
            return new TopicExchange("topicNoListenexchange");
        }

        @Bean
        Binding bindingExchangeMessage(@Qualifier("s1") Queue queueMessage, TopicExchange exchange) {
            return BindingBuilder.bind(queueMessage).to(exchange).with("topicNoListen.s1");
        }

        @Bean
        Binding bindingExchangeMessages(@Qualifier("s2") Queue queueMessages, TopicExchange exchange) {
            return BindingBuilder.bind(queueMessages).to(exchange).with("topicNoListen.#");//*表示一个词,#表示零个或多个词
        }
}