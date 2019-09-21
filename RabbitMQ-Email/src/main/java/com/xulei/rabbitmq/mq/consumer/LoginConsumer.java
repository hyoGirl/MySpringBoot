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
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 12:37
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginConsumer {


    @Autowired
    private LoginLogService loginLogService;


    @Autowired
    private MsgLogService msgLogService;

    // 最大重复消费次数
    private static final int MAX_TRY_COUNT = 3;


    @RabbitListener(queues = LoginMQConfig.LOGIN_LOG_QUEUE_NAME)
    public  void consume(Message message, Channel channel)throws  Exception{
        log.info("收到消息: {}", message.toString());
        String data = new String(message.getBody());
        LoginLog logData = JSON.parseObject(data, LoginLog.class);
        String msgId = logData.getMsgId();
        MsgLog msgLog = msgLogService.getOne(new QueryWrapper<MsgLog>().eq("msg_id", msgId));
        if(msgLog==null || msgLog.getStatus().equals(Constant.MsgLogStatus.CONSUMED_SUCCESS)){
            log.info("重复消费, msgId: {}", msgId);
            return;
        }
        MessageProperties messageProperties =   message.getMessageProperties();
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
            loginLogService.save(logData);
            msgLogService.updateStatus(msgId, Constant.MsgLogStatus.CONSUMED_SUCCESS);
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            log.error("日志信息入库失败！！！");
            Integer tryCount = msgLog.getTryCount();
            if(tryCount<MAX_TRY_COUNT){
                tryCount++;
                msgLog.setTryCount(tryCount);
                msgLogService.updateById(msgLog);
                channel.basicNack(deliveryTag,false,true);
            }else{
                channel.basicNack(deliveryTag,false,false);
            }
        }
    }

}
