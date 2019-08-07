package com.xulei.observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 22:19
 * @Version 1.0
 */
@SpringBootApplication
@EnableAsync
public class ObserverApp {


    public static void main(String[] args) {
        SpringApplication.run(ObserverApp.class,args);

    }
}
