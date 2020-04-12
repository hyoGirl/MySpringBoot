package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

/**
 * @author XULEI
 * @ClassName ExcludeAutoApp
 * @description TODO
 * @Date 2020/4/11 18:45
 * @Version 1.0
 */
//@SpringBootApplication(exclude={
//        RedisAutoConfiguration.class,
//        RedisRepositoriesAutoConfiguration.class
//})
@SpringBootApplication
public class ExcludeAutoApp {

    public static void main(String[] args) {

        SpringApplication.run(ExcludeAutoApp.class,args);

    }
}
