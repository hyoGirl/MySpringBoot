package com.xulei.test;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * @author ashura1110
 * @ClassName Config
 * @description TODO
 * @Date 2019/6/17 23:20
 * @Version 1.0
 */
@Component
public class Config implements SchedulingConfigurer{

    //https://blog.csdn.net/qq_35974759/article/details/81775545
    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(10);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());


    }
}
