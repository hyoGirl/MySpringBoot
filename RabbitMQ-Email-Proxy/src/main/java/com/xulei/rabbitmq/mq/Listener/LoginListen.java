package com.xulei.rabbitmq.mq.Listener;

import com.rabbitmq.client.Channel;
import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.config.LoginMQConfig;
import com.xulei.rabbitmq.mq.BaseConsumer;
import com.xulei.rabbitmq.mq.BaseConsumerProxy;
import com.xulei.rabbitmq.mq.consumer.LoginConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 16:17
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginListen {

    @Autowired
    private LoginConsumer loginLogConsumer;

    @Autowired
    private MsgLogService msgLogService;

    @RabbitListener(queues = LoginMQConfig.LOGIN_LOG_QUEUE_NAME)
    public void consume(Message message, Channel channel) throws IOException {
        BaseConsumerProxy baseConsumerProxy = new BaseConsumerProxy(loginLogConsumer, msgLogService);
        BaseConsumer proxy = (BaseConsumer) baseConsumerProxy.getProxy();
        if(null != proxy){
            proxy.consume(message, channel);
        }

    }



}
