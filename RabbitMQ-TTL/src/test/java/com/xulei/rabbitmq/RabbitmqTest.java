package com.xulei.rabbitmq;

import com.xulei.rabbitmq.enums.QueueEnum;
import com.xulei.rabbitmq.producer.MsgSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/9 22:28
 * @Version 1.0
 */
@SpringBootTest(classes = RabbitMQApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitmqTest {

    @Autowired
    MsgSend msgSend;

    @Test
    public void sendTest(){

        msgSend.send("测试延迟消费15秒,写入时间：" + new Date(),
                QueueEnum.MSG_TTL_QUEUE.getExchangeName(),
                QueueEnum.MSG_TTL_QUEUE.getRouteKey(),
                15*1000);
        msgSend.send("测试延迟消费10秒,写入时间：" + new Date(),
                QueueEnum.MSG_TTL_QUEUE.getExchangeName(),
                QueueEnum.MSG_TTL_QUEUE.getRouteKey(),
                10*1000);

    }

}
