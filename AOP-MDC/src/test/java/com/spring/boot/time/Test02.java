package com.spring.boot.time;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 22:16
 * @Version 1.0
 */
public class Test02 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        String source="2019-01-11";

        for (int i = 0; i < 20; i++) {
            executorService.submit(()->{
                System.out.println(ThreadTime.parse(source));
            });
        }
        executorService.shutdown();




    }
}
