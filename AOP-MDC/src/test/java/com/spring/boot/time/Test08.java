package com.spring.boot.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 22:23
 * @Version 1.0
 */
public class Test08 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        String source="2019-01-11";

        for (int i = 0; i < 20; i++) {
            executorService.submit(()->{
                LocalDate localDate = Jdk8.parse(source);
                ZoneId zone = ZoneId.systemDefault();

                Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();


                Date date = Date.from(instant);


                System.out.println(date);
            });
        }
        executorService.shutdown();



    }
}
