package com.spring.boot;

import java.util.concurrent.TimeUnit;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 21:51
 * @Version 1.0
 */
public class TestSiSuo {


    public static void main(String[] args) {




        Object obj1=new Object();
        Object obj2=new Object();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "-->  开始获取obj1锁");

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + "-->  开始获取obj2锁");
                    }
                }
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "-->  开始获取obj2锁");
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + "-->  开始获取obj1锁");
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();


    }
}
