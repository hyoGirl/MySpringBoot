package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/10 15:35
 * @Version 1.0
 */
public class Thread04 {



    public static void main(String[] args) {

        List<String> list=new ArrayList<>(10);
        Object lock=new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(15);


        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true){
                    synchronized (lock){
                        while(list.size()==10){
                            try {
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
                        System.out.println("当前仓库保存的数量为： -->"+list.size());
                        lock.notifyAll();
                    }
                }}
            });
        }
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true){
                    synchronized (lock){
                        while(list.size()==0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.remove(0);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("当前仓库剩下的数量为： ------------>"+list.size());
                        lock.notifyAll();
                    }
                }}
            });
        }



    }
}
