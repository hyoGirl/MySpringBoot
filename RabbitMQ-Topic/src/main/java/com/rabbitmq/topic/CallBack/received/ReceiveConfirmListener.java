package com.rabbitmq.topic.CallBack.received;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;


@Service("receiveConfirmListener")
public class ReceiveConfirmListener implements ChannelAwareMessageListener {

	 /**
     * 
     * 默认情况下,如果没有配置手动ACK, 那么Spring Data AMQP 会在消息消费完毕后自动帮我们去ACK
     * 存在问题：如果报错了,消息不会丢失,但是会无限循环消费,一直报错,如果开启了错误日志很容易将磁盘空间耗完
     * 解决方案：手动ACK,或者try-catch 然后在 catch 里面讲错误的消息转移到其它的系列中去
     * spring.rabbitmq.listener.simple.acknowledge-mode=manual
     * <p>
     *
     * @param mail 监听的内容
     */
	
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        try {

            System.out.println(
                    "消费端接收到消息:" + message.getMessageProperties() + ":" + new String(message.getBody()));

            //其中的false表示需要后面显示的调用basicAck，告诉MQ将msg删除
            // deliveryTag是消息传送的次数

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);


        } catch (Exception e) {

            e.printStackTrace();

            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);


        }
    }
}
