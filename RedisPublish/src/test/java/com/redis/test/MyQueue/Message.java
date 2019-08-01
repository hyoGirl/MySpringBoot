package com.redis.test.MyQueue;

import lombok.Data;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/1 21:30
 * @Version 1.0
 */
@Data
public class Message {

    /**
     * 消息id
     */
    private String id;
    /**
     * 消息延迟/毫秒
     */
    private long delay;

    /**
     * 消息存活时间
     */
    private int ttl;
    /**
     * 消息体，对应业务内容
     */
    private String body;
    /**
     * 创建时间，如果只有优先级没有延迟，可以设置创建时间为0
     * 用来消除时间的影响
     */
//    private long createTime;

}