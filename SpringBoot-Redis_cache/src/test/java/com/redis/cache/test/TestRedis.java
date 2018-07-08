package com.redis.cache.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.cache.pojo.User;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {
	
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void testSet() throws JsonProcessingException {
    	
        ValueOperations<String, String> opsForValue = this.redisTemplate.opsForValue();
        
        List list=new ArrayList();
        
        User user1=new User();
        user1.setId(15L);
        user1.setName("AAAAAA");
        user1.setAge(18);
        
        User user2=new User();
        user2.setId(15L);
        user2.setName("AAAAAA");
        user2.setAge(18);
        
        list.add(user1);
        list.add(user2);
        
        
        //转换单独一个对象
        //String data = objectMapper.writeValueAsString(user);
        
        String writeValueAsString = objectMapper.writeValueAsString(list);
        
        
//        opsForValue.set("userdata", data);
        opsForValue.set("userlist02", writeValueAsString);
        
        
        
        
        System.out.println(opsForValue.get("userdata"));
    }
}