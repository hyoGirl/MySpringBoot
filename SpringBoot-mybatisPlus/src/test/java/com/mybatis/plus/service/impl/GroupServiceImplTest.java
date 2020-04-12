package com.mybatis.plus.service.impl;

import com.alibaba.fastjson.JSON;
import com.mybatis.plus.MyBean.MyService;
import com.mybatis.plus.MybatisPlusApp;
import com.mybatis.plus.entity.Group_info;
import com.mybatis.plus.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisPlusApp.class)
public class GroupServiceImplTest {


    @Autowired
    GroupService groupService;


    @Autowired
    MyService myService;


    @Test
    public void test(){

        List<Group_info> group_infos = groupService.list();
        


        System.out.println(JSON.toJSONString(group_infos));
    }
    @Test
    public void test2(){

        myService.show();
    }

}