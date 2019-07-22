package com.redis.test;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 19:24
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.redis.publish.RedisPublishApp;
import com.redis.publish.data.Message;
import com.redis.publish.publish.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = RedisPublishApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

    @Autowired
    Publisher publisher;


    @Test
    public void testSend(){

        Message msg=new Message();

        msg.setMsg("test001");

        msg.setName("redis");


        publisher.pushMessage("user", msg);


    }
}
