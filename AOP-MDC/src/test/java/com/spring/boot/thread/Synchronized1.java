package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/31 19:50
 * @Version 1.0
 */
public class Synchronized1 {

    List list = new ArrayList(10);
    Object lock = new Object();

    public void get() throws Exception {
        synchronized (lock) {
            while (list.size() == 0) {
                lock.wait();
            }
            list.remove(0);
            Thread.sleep(200);
            System.out.println("已经消费了一个。剩下数目为：" + list.size());
            lock.notifyAll();
        }
    }

    public void put(String name) throws Exception {
        synchronized (lock) {
            while (list.size() == 10) {
                lock.wait();
            }
            list.add(name);
            Thread.sleep(400);
            System.out.println("保存的数目为：" + list.size());
            lock.notifyAll();
        }
    }


    public static void main(String[] args) {


        final Synchronized1 synchronized1 = new Synchronized1();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            synchronized1.put("包子");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            synchronized1.get();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
