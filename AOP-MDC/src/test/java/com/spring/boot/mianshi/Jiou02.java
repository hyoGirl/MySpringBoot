package com.spring.boot.mianshi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/27 11:17
 * @Version 1.0
 */
public class Jiou02 {
    static AtomicInteger cxsNum = new AtomicInteger(0);
    static volatile boolean flag = false;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; cxsNum.get() < 100; ) {
                    if (!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "-->" + cxsNum.get());
                        flag = true;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; cxsNum.get() < 100; ) {
                    if (flag && (cxsNum.incrementAndGet() % 2 == 1)) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "-->" + cxsNum.get());
                        flag = false;
                    }
                }
            }
        }).start();
    }
}
