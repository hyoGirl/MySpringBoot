package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/22 22:44
 * @Version 1.0
 */
@SpringBootApplication
@RestController
public class AutoApp {



    @Value("${some.key:true}")
    private  boolean  flag;

    @Autowired
    private Hello hello;

    @RequestMapping("/")
    public String index() {
        System.out.println("------------>"+flag);
        return hello.sayHello();
    }

//    原文：https://blog.csdn.net/zxc123e/article/details/80222967

    public static void main(String[] args) {

        SpringApplication.run(AutoApp.class,args);
    }
}
