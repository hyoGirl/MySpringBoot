package com.xulei.design;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/28 11:19
 * @Version 1.0
 */
public class Test003 {


    static  Object obj=new Object();
    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    for (int i = 0; i < 10; i+=2) {
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                        obj.notify();
                        try {
                            obj.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    for (int i = 1; i < 10; i+=2) {
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                        obj.notify();
                        try {
                            obj.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t2").start();



    }
}
