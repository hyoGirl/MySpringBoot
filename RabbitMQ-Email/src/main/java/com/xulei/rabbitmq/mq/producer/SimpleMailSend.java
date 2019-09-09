package com.xulei.rabbitmq.mq.producer;

import com.alibaba.fastjson.JSON;
import com.xulei.rabbitmq.code.dao.MsgLogDao;
import com.xulei.rabbitmq.code.entity.Mail;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.config.MqConfig;
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
public class SimpleMailSend {


    @Autowired
    private MsgLogDao msgLogDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Mail mail) {
        String msgId = RandomUtil.UUID32();

        mail.setMsgId(msgId);

        MsgLog msgLog = new MsgLog(msgId, mail, MqConfig.MAIL_EXCHANGE_NAME, MqConfig.MAIL_ROUTING_KEY_NAME);

        msgLogDao.insert(msgLog);// 消息入库

        CorrelationData correlationData = new CorrelationData(msgId);
        Message message = MessageBuilder.withBody(JSON.toJSONString(mail).getBytes()).build();

        rabbitTemplate.convertAndSend(MqConfig.MAIL_EXCHANGE_NAME,
                MqConfig.MAIL_ROUTING_KEY_NAME,
                message,
                correlationData);// 发送消息

        // 使用错误的交换器名字。来验证是不是不会发送到队列中
//        rabbitTemplate.convertAndSend("errorName",
//                MqConfig.MAIL_ROUTING_KEY_NAME,
//                message,
//                correlationData);// 发送消息

        // 使用错误的路由名字。来验证交换器发送到
//        rabbitTemplate.convertAndSend(MqConfig.MAIL_EXCHANGE_NAME,
//                "errorName",
//                message,
//                correlationData);// 发送消息
    }

}
