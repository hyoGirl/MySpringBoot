package com.xulei.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ashura1110
 * @ClassName Schedule01
 * @description TODO
 * @Date 2019/6/17 23:13
 * @Version 1.0
 */
@Component
public class Schedule01 {


    //https://blog.csdn.net/weixin_42849915/article/details/86743705
    Logger log = LoggerFactory.getLogger(Schedule01.class);

//    @Async
    @Scheduled(cron = "*/2 * * * * ?")
    public void task1() throws InterruptedException {
        log.error("我是task1111，我需要执行 10s 钟的时间，我的线程的 id == > {}，时间 == >{}", Thread.currentThread().getId(), new Date());
        Thread.sleep(10000);
        log.error("task1111 ending ,我的线程的 id == > {} , 时间 == > {}", Thread.currentThread().getId(), new Date());
    }

//    @Async
    @Scheduled(cron = "*/4 * * * * ?")
    public void task2() throws InterruptedException {
        log.error("我是task2222，我需要执行 2s 钟的时间，我的线程的 id == > {}，时间 == >{}", Thread.currentThread().getId(), new Date());
        Thread.sleep(2000);
        log.error("task2222 ending ,我的线程的 id == > {} , 时间 == > {}", Thread.currentThread().getId(), new Date());
    }
}
