package com.xulei.rabbitmq.config;

import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {

     @Autowired
     MsgLogService msgLogService;
     private Logger log= LoggerFactory.getLogger(MqConfig.class);


     // 发送邮件
     public static final String MAIL_QUEUE_NAME = "mail.queue";
     public static final String MAIL_EXCHANGE_NAME = "mail.exchange";
     public static final String MAIL_ROUTING_KEY_NAME = "mail.routing.key";

     //消息队列
     @Bean
     public Queue mailQueue() {
          return new Queue(MAIL_QUEUE_NAME,true);
     }

     //邮件交换器
     @Bean
     public DirectExchange mailExchange() {
          return new DirectExchange(MAIL_EXCHANGE_NAME, true, false);
     }

     // 交换器与路由绑定
     @Bean
     public Binding mailBinding() {
          return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MAIL_ROUTING_KEY_NAME);
     }

     @Autowired
     private CachingConnectionFactory connectionFactory;

     @Bean
     public RabbitTemplate rabbitTemplate(){
          RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);

          rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
               if(ack){
                    log.info("消息成功发送到Exchange");
                    String msgId = correlationData.getId();
                    msgLogService.updateStatus(msgId, Constant.MsgLogStatus.DELIVER_SUCCESS);
               }else{
                   log.info("消息发送到Exchange失败, {}, cause: {}",correlationData,cause);
               }
          });
          //触发setReturnCallback回调必须设置mandatory=true, 否则Exchange没有找到Queue就会丢弃掉消息, 而不会触发回调
          rabbitTemplate.setMandatory(true);

          // 消息是否从Exchange路由到Queue, 注意: 这是一个失败回调, 只有消息从Exchange路由到Queue失败才会回调这个方法
          rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
               log.info("消息从Exchange路由到Queue失败: exchange: {}, route: {}, replyCode: {}, replyText: {}, message: {}", exchange, routingKey, replyCode, replyText, message);
          });
          return rabbitTemplate;
     }


}