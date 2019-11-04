package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/31 19:34
 * @Version 1.0
 */
public class Thread05 {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>(10);
        Object lock = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (lock) {
                            while (list.size() == 10) {
                                try {
                                    System.out .println("仓库达到上限了，需要消费");
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            list.add("面包");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("当前仓库保存的数量为： -->" + list.size());
                            lock.notifyAll();
                        }
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (lock) {
                            while (list.size() == 0) {
                                try {
                                    System.out .println("仓库没有库存了，需要生产");
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            list.remove(0);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("当前仓库剩下的数量为： ------------>" + list.size());
                            lock.notifyAll();
                        }
                    }
                }
            }).start();
        }


    }
}
