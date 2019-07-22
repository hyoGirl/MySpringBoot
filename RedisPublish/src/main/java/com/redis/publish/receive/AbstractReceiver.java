package com.redis.publish.receive;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 19:01
 * @Description:
 */
public abstract  class AbstractReceiver {

    public abstract void receiveMessage(Object message);
}
