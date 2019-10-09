package com.xulei.rabbitmq.enums;

import lombok.Getter;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/9 22:31
 * @Version 1.0
 */
@Getter
public enum  QueueEnum {

    MSG_QUEUE("msg02.exchange","msg02.queue","msg02.routing.key"),
    MSG_TTL_QUEUE("msg02.exchange.ttl","msg02.queue.ttl","msg02.ttl.routing.key");


    // 交换器
    private String exchange;
    // 队列名字
    private String name;
    // 路由key
    private String routeKey;


    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

}
