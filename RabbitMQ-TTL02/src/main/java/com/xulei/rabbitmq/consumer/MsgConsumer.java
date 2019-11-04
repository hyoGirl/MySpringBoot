package com.xulei.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/14 22:27
 * @Version 1.0
 */
@Component
@RabbitListener(queues ="queue.dlx")
public class MsgConsumer {

    private Logger logger= LoggerFactory.getLogger(MsgConsumer.class);

    /**
     *
     * 20分钟订单延迟处理的过程，
     * 第一种解决方案：
     * 1：生成订单，
     * 2：与此同时，正常程序会调用处理订单的接口，修改为处理成功
     * 3：放入到延迟队列中，15分钟后过期，
     * 4：与此同时，正常程序会调用处理订单的接口，修改为处理成功
     * 5：15分钟时间到后，延迟消息发送到一个真实队列中，取出消息，查询数据库判断是不是处理完毕
     *    如果处理完毕后，就不需要管
     *    如果没有处理完毕，就消费消息，处理数据。关闭订单
     * 6： 商品回库问题，不会。
     *
     *
     * 第二种解决方案：
     * 1：定时任务间隔扫描表，表里面有个有效时间字段，还有状态，定时任务处理的时候，用当前时间与这个有效时间去判断，如果大于有效时间，同时这个状态还是未支付的。就直接取消订单
     *
     * @param content
     */
    @RabbitHandler
    public void handler(String content) {
        logger.info("消费内容：{}", content);
    }

}
