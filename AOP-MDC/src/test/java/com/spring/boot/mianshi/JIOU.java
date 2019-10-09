package com.spring.boot.mianshi;

import org.apache.tomcat.websocket.server.WsHttpUpgradeHandler;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/27 10:59
 * @Version 1.0
 */
public class JIOU {
    static int total = 20;
    static int key = 0;
    static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (key < total) {
                    synchronized (obj) {
                        if (key % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + "-->" + key++);
                        } else {
                            obj.notifyAll();
                            try {
                                obj.wait(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (key < total) {
                    synchronized (obj) {
                        if (key % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "-->" + key++);
                        } else {
                            obj.notifyAll();
                            try {
                                obj.wait(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
