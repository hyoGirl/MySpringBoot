package com.xulei.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ashura1110
 * @ClassName App
 * @description TODO
 * @Date 2019/6/17 23:12
 * @Version 1.0
 */
@EnableScheduling
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class,args);

    }
}
