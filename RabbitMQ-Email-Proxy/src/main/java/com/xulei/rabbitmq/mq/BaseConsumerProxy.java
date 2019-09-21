package com.xulei.rabbitmq.mq;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.code.service.MsgLogService;
import com.xulei.rabbitmq.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description 动态代理修改
 * @Date 2019/9/21 15:03
 * @Version 1.0
 */
@Slf4j
public class BaseConsumerProxy {


    private Object target;

    private MsgLogService msgLogService;

    public BaseConsumerProxy(Object target,MsgLogService msgLogService){
        this.target=target;
        this.msgLogService=msgLogService;
    }


    // 最大重复消费次数
    private static final int MAX_TRY_COUNT = 3;

    public Object getProxy(){

        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Message message=(Message) args[0];
                Channel channel=(Channel) args[1];
                //判断是不是重复
                MessageProperties messageProperties = message.getMessageProperties();
                String data = new String(message.getBody(),"UTF-8");
                JSONObject jsonObject = (JSONObject) JSON.parse(data);

                String msgId = jsonObject.get("msgId").toString();
//                String correlationId = getCorrelationId(message);
                long deliveryTag = messageProperties.getDeliveryTag();
                log.info("获取到的相关id: {}",msgId);
                MsgLog msgLog = msgLogService.selectByMsgId(msgId);

                //获取不到correlationId 一直为null
//                if (isConsumed(correlationId)) {// 消费幂等性, 防止消息被重复消费
//                    log.info("重复消费, correlationId: {}", correlationId);
//                    return null;
//                }
                if (isConsumed(msgId)) {// 消费幂等性, 防止消息被重复消费
                    log.info("重复消费, msgId: {}", msgId);
                    return null;
                }
                //执行逻辑
                try {
                    Object result = method.invoke(target, args);
                    msgLogService.updateStatus(msgId,Constant.MsgLogStatus.CONSUMED_SUCCESS);
//                    msgLogService.updateStatus(correlationId,Constant.MsgLogStatus.CONSUMED_SUCCESS);
                    channel.basicAck(deliveryTag,false);
                    return result;
                } catch (Exception e) {
                    Integer tryCount = msgLog.getTryCount();
                    if(tryCount<MAX_TRY_COUNT){
                        tryCount++;
                        msgLog.setTryCount(tryCount);
                        msgLogService.updateById(msgLog);
                        channel.basicNack(deliveryTag, false, true);
                    }else{
                        channel.basicNack(deliveryTag, false, false);
                    }
                    return  null;
                }
            }
        });
        return proxyInstance;
    }

    /**
     * 消息是否重复消费
     * @param correlationId
     * @return
     */
    private boolean isConsumed(String correlationId) {
        MsgLog msgLog = msgLogService.selectByMsgId(correlationId);
        if (null == msgLog || msgLog.getStatus().equals(Constant.MsgLogStatus.CONSUMED_SUCCESS)) {
            return true;
        }
        return false;
    }

    private String getCorrelationId(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        Map<String, Object> headers = messageProperties.getHeaders();
        String correlationId = null;
        for(Map.Entry entry:headers.entrySet()){
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (key.equals("spring_returned_message_correlation")) {
                correlationId = value;
            }
        }
        return correlationId;
    }
}
