package com.xulei.rabbitmq.producer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/9 22:05
 * @Version 1.0
 */
@Component
public class MsgSend {

    private Logger logger= LoggerFactory.getLogger(MsgSend.class);

    @Autowired
    private AmqpTemplate rabbitMqTemplate;


    /**
     *   发送延迟消息
     * @param messageContent  消息主体
     * @param exchange    交换机
     * @param routerKey   路由key
     * @param delayTimes   延迟时间
     */
    public void send(Object messageContent, String exchange, String routerKey, final long delayTimes){

        /**
         * Convert a Java object to an Amqp {@link Message} and send it to a specific exchange with a specific routing key.
         *
         * @param exchange the name of the exchange
         * @param routingKey the routing key
         * @param message a message to send
         * @param messagePostProcessor a processor to apply to the message before it is sent
         * @throws AmqpException if there is a problem
         */
        if(!StringUtils.isEmpty(exchange)){
            logger.info("延迟：{}毫秒写入消息队列：{}，消息内容：{}", delayTimes, routerKey, JSON.toJSONString(messageContent));
            rabbitMqTemplate.convertAndSend(exchange,routerKey,messageContent,message -> {
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            });
        }else{
            logger.error("未找到队列消息：{}，所属的交换机", exchange);
        }
    }

}
