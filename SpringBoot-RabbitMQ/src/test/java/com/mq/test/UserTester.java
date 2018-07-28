package com.mq.test;

import com.rabbitmq.java.RabbitMQApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Auther: Administrator
 * @Date: 2018/7/10 0010 17:31
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApp.class)
public class UserTester {

    //模拟mvc测试
    private MockMvc mockMvc;


    //注入web上下文
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    /**
     * 测试添加用户
     *
     * @throws Exception
     */

    @Test
    public void testUserAdd() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .param("userName", "yuqiyu")
                .param("name", "恒宇少年")
                .param("age", "23")
                /*.param("id",2L)*/
                )
                .andDo(MockMvcResultHandlers.log()).andReturn();

    }


}
