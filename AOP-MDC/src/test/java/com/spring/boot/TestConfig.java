package com.spring.boot;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/29 22:30
 * @Version 1.0
 */
public class TestConfig {


    public static void main(String[] args) {


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


        for (int i = 0; i < 3; i++) {
            String data = "ASDF-->"+i;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(data + LocalTime.now());
                }
            },1+i, TimeUnit.SECONDS);

        }


//        AtomicInteger atomicInteger=new AtomicInteger(0);
//
//        System.out.println(atomicInteger.getAndIncrement());


    }

}

//        ThreadExecutePoolConfig threadExecutePoolConfig = new ThreadExecutePoolConfig();
//
//        for (int i = 0; i < 3; i++) {
//            threadExecutePoolConfig.threadPoolTaskExecutOrTask().execute(new Runnable() {
//                @Override
//                public void run() {
//
//                    String data="ASDF-->";
//                    System.out.println(data+ LocalTime.now());
//                }
//            });
//
//        }



