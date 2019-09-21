package com.xulei.rabbitmq;

import com.xulei.rabbitmq.code.dao.MsgLogDao;
import com.xulei.rabbitmq.code.entity.Mail;
import com.xulei.rabbitmq.mq.producer.SimpleMailSend;
import com.xulei.rabbitmq.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/8 16:46
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitMQProxyApp.class)
public class TestMailSend {


    @Autowired
    private MsgLogDao msgLogDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    SimpleMailSend simpleMailSend;


    @Test
    public void send() {
        Mail mail=new Mail();

        mail.setContent("测试MQ代码002");
        mail.setTitle("测试MQ代码002");
        mail.setTo("xulei912@163.com");

        String msgId = RandomUtil.UUID32();
        mail.setMsgId(msgId);

        simpleMailSend.send(mail);
    }




}
