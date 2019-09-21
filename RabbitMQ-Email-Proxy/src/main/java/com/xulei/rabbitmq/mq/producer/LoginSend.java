package com.xulei.rabbitmq.mq.producer;

import com.alibaba.fastjson.JSON;
import com.xulei.rabbitmq.code.dao.MsgLogDao;
import com.xulei.rabbitmq.code.entity.LoginLog;
import com.xulei.rabbitmq.code.entity.Mail;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.config.LoginMQConfig;
import com.xulei.rabbitmq.config.MailMQConfig;
import com.xulei.rabbitmq.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/8 16:08
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginSend {


    @Autowired
    private MsgLogDao msgLogDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(LoginLog loginLog) {
        String msgId = RandomUtil.UUID32();
        loginLog.setMsgId(msgId);
        MsgLog msgLog = new MsgLog(msgId, loginLog, LoginMQConfig.LOGIN_LOG_EXCHANGE_NAME, LoginMQConfig.LOGIN_LOG_ROUTING_KEY_NAME);
        msgLogDao.insert(msgLog);// 消息入库

        CorrelationData correlationData = new CorrelationData(msgId);
        Message message = MessageBuilder.withBody(JSON.toJSONString(loginLog).getBytes()).build();

        rabbitTemplate.convertAndSend(LoginMQConfig.LOGIN_LOG_EXCHANGE_NAME,
                LoginMQConfig.LOGIN_LOG_ROUTING_KEY_NAME,
                message,
                correlationData);// 发送消息

    }

}
