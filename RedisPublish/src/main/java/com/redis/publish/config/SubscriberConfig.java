package com.redis.publish.config;

import com.redis.publish.receive.UserReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 17:07
 * @Description: 消息的订阅者
 */
@Configuration
public class SubscriberConfig {



    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * @param connectionFactory
     * @param userListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(JedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter userListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(userListenerAdapter, new PatternTopic("user"));
        return container;
    }


    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     * @param receiver
     * @return
     */
    @Bean
    public MessageListenerAdapter userListenerAdapter(UserReceiver receiver) {

        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，
        // 利用反射的方法调用“receiveMessage”
        //也有好几个重载方法，
        // 这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看

        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


    /**
     * 具体的接受者
     * @return
     */
    @Bean
    public UserReceiver userReceiver() {
        return new UserReceiver();
    }


}
