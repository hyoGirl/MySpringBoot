package com.spring.boot.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/31 19:53
 * @Version 1.0
 */
public class Block {
    public static void main(String[] args) throws Exception{

        final BlockingQueue blockingQueue=new ArrayBlockingQueue(10);

        for (int i = 0; i < 5; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            blockingQueue.put("包子： ");
                            System.out.println("仓库保存的个数为：" + blockingQueue.size());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            blockingQueue.take();
                            System.out.println("消费者消费了一个，现在仓库剩下的个数为：" + blockingQueue.size());
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
