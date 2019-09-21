package com.xulei.rabbitmq.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.xulei.rabbitmq.code.entity.Mail;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.common.Constant;
import com.xulei.rabbitmq.config.MailMQConfig;
import com.xulei.rabbitmq.config.MqConfig;
import com.xulei.rabbitmq.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;


/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/8 15:35
 * @Version 1.0
 */
@Component
@Slf4j
public class SimpleMailConsumer {

    @Autowired
    private MsgLogService msgLogService;

    @Autowired
    private MailUtil mailUtil;

    @RabbitListener(queues = MailMQConfig.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel)throws  Exception{
        String data = new String(message.getBody());
        Mail mail = JSON.parseObject(data, Mail.class);
        log.info("收到消息: {}", mail.toString());
        mailUtil.send(mail);
    }
}
