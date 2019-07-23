package com.redis.publish.receive;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 19:02
 * @Description:
 */
@Slf4j
public class UserReceiver extends AbstractReceiver{

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Override
    public void receiveMessage(Object message) {

        System.out.println("=====================================");


        System.out.println("接收到商品消息："+JSON.toJSONString(message));
//        logger.info("接收到商品消息：{}", JSON.toJSONString(message));

    }
}
