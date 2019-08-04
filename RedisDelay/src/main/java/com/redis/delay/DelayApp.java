package com.redis.delay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/4 10:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableAsync
public class DelayApp {


    public static void main(String[] args) {

        SpringApplication.run(DelayApp.class,args);

    }
}
