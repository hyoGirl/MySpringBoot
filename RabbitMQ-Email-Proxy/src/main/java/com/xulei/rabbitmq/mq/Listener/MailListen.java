package com.xulei.rabbitmq.mq.Listener;

import com.rabbitmq.client.Channel;
import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.config.MailMQConfig;
import com.xulei.rabbitmq.mq.BaseConsumer;
import com.xulei.rabbitmq.mq.BaseConsumerProxy;
import com.xulei.rabbitmq.mq.consumer.SimpleMailConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 16:23
 * @Version 1.0
 */
@Component
@Slf4j
public class MailListen {

    @Autowired
    private SimpleMailConsumer simpleMailConsumer;

    @Autowired
    private MsgLogService msgLogService;

    @RabbitListener(queues = MailMQConfig.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel)throws  Exception{
        BaseConsumerProxy baseConsumerProxy = new BaseConsumerProxy(simpleMailConsumer, msgLogService);
        BaseConsumer proxy = (BaseConsumer) baseConsumerProxy.getProxy();
        if(null != proxy){
            proxy.consume(message, channel);
        }
    }
}
