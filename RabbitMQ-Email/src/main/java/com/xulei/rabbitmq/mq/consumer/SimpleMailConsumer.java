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

    // 最大重复消费次数
    private static final int MAX_TRY_COUNT = 3;

    @RabbitListener(queues = MailMQConfig.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel)throws  Exception{
        String data = new String(message.getBody());
        Mail mail = JSON.parseObject(data, Mail.class);
        log.info("收到消息: {}", mail.toString());
        String msgId = mail.getMsgId();
        MsgLog msgLog = msgLogService.selectByMsgId(msgId);

        /**
         * 通过判断状态来确认消息重复消费
         */

        if (null == msgLog || msgLog.getStatus().equals(Constant.MsgLogStatus.CONSUMED_SUCCESS)) {// 消费幂等性
            log.info("重复消费, msgId: {}", msgId);
            return;
        }
        MessageProperties properties = message.getMessageProperties();
        long tag = properties.getDeliveryTag();
        boolean success = mailUtil.send(mail);
        if (success) {

            /**
             * 如果成功了。就更改消费状态
             */

            msgLogService.updateStatus(msgId, Constant.MsgLogStatus.CONSUMED_SUCCESS);
            //Acknowledge one or several received
//            multiple true to acknowledge all messages up to and
//                    including the supplied delivery tag; false to acknowledge just
//                    the supplied delivery tag.

//            注释掉这行，手动ack模式下, 消费端必须进行手动确认(ack)。会发现untrack存在一条数据
            channel.basicAck(tag, false);// 手动消费确认
        } else {

            /**
             * 失败了，就判断失败次数，是否丢弃，或者重新入队列
             */

            //Reject one or several received messages.
            //requeue：被拒绝的是否重新入队列
            //multiple 是否批量
            Integer tryCount = msgLog.getTryCount();
            if(tryCount<MAX_TRY_COUNT){
                tryCount++;
                msgLog.setTryCount(tryCount);
                msgLogService.updateById(msgLog);
                channel.basicNack(tag, false, true);
            }else{
                channel.basicNack(tag, false, false);
            }
//            channel.basicNack(tag, false, true);
        }
    }
}
