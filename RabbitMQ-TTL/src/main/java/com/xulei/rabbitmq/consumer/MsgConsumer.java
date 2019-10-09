package com.xulei.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description 模拟消费者的消费
 * @Date 2019/10/9 22:00
 * @Version 1.0
 */
@Component
@RabbitListener(queues ="msg02.queue")
public class MsgConsumer {

    private Logger logger= LoggerFactory.getLogger(MsgConsumer.class);


    @RabbitHandler
    public void handler(String content) {
        logger.info("消费内容：{}", content);
    }
}
