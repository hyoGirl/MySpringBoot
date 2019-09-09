package com.xulei.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description  学习如何使用redis作为限流器
 * @Date 2019/9/7 9:49
 * @Version 1.0
 */
@SpringBootApplication
public class RedisLimitApp {


    public static void main(String[] args) {
        SpringApplication.run(RedisLimitApp.class,args);

    }
}
