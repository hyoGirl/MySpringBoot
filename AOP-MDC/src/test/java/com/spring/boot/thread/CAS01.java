package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/6 11:04
 * @Version 1.0
 */
public class CAS01 {

    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private int i=0;

    public static void main(String[] args) {
        final  CAS01 cas01=new CAS01();
        long timeMillis = System.currentTimeMillis();
        List<Thread> ts=new ArrayList<>(600);
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    cas01.safeCount();
                    cas01.count();
                }
            });
            ts.add(thread);
        }
        for (Thread t:ts){
            t.start();
        }

        for (Thread t:ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas01.atomicInteger.get());
        System.out.println(cas01.i);
        System.out.println(System.currentTimeMillis()-timeMillis);
    }

    private void count() {
        i++;

    }

    private void safeCount() {
        for (;;){
            int i=atomicInteger.get();
            boolean flag = atomicInteger.compareAndSet(i, ++i);
            if(flag){
                break;
            }
        }
    }


}
