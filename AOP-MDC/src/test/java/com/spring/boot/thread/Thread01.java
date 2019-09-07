package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/10 14:28
 * @Version 1.0
 */
public class Thread01 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(1);
        Object lock = new Object();
        Thread get = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    synchronized (lock) {
                        while (list.size() == 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.remove(0);
                        System.out.println(Thread.currentThread().getName() + " 消费，总量为++++" + list.size());
                        lock.notify();
                    }
                }
            }
        }, "get");

        Thread put = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (list.size() != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.add("产品");
                        System.out.println(Thread.currentThread().getName() + " 生产，总量为--》" + list.size());
                        lock.notify();
                    }
                }
            }
        }, "put");
        get.start();
        put.start();
    }
}
