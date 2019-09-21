package com.xulei.rabbitmq.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.Channel;
import com.xulei.rabbitmq.code.entity.LoginLog;
import com.xulei.rabbitmq.code.entity.Mail;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.code.service.LoginLogService;
import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.common.Constant;
import com.xulei.rabbitmq.config.LoginMQConfig;
import com.xulei.rabbitmq.config.MailMQConfig;
import com.xulei.rabbitmq.mq.BaseConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 12:37
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginConsumer implements BaseConsumer {

    @Autowired
    private LoginLogService loginLogService;


    @Override
    public void consume(Message message, Channel channel) throws IOException {
        log.info("收到消息: {}", message.toString());
        String data = new String(message.getBody());
//        LoginLog loginLog = MessageHelper.msgToObj(message, LoginLog.class);
        LoginLog logData = JSON.parseObject(data, LoginLog.class);
        loginLogService.save(logData);

    }
}
