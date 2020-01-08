package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mapper.user.UserMapper;
import com.spring.boot.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public List<User> findAll() {
        return userMapper.selectAll();
    }
    @GetMapping("/id")
    public User findID() {
        return userMapper.findUserById(11L);
    }

    @GetMapping("/add")
    public User addUser() {

        User user = new User();
        user.setAddress("測試地址");
        user.setAge(18);
        user.setName("测试人员");
        user.setPwd("123456");
        user.setSex("男");

        List<String> data=new ArrayList<>();

        data.add("A");
        data.add("B");
        data.add("C");
//        user.setHobby(data);






        userMapper.addUser(user);

        User user1 = userMapper.findUserById(user.getId());

        return user1;

    }
}
