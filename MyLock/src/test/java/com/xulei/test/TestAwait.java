package com.xulei.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/26 22:14
 * @Version 1.0
 */
public class TestAwait {

    public static void main(String[] args) throws  Exception{

        CountDownLatch countDownLatch=new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();

                System.out.println(2);

                countDownLatch.countDown();
            }
        }).start();


        countDownLatch.await();

        System.out.println(3);

    }
}
