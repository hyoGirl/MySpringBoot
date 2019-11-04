package com.spring.boot.mianshi2;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/12 12:18
 * @Version 1.0
 */
public class JO {

    static int  num=100;
    static int key = 0;
    static Object obj = new Object();



    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(key< num){
                    synchronized (obj){
                        if(key %2==0){
                            System.out.println(Thread.currentThread().getName()+"--->"+(key++));
                        }
                        obj.notifyAll();
                        try {
                            obj.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(key< num){
                    synchronized (obj){
                        if(key %2==1){
                            System.out.println(Thread.currentThread().getName()+"--->"+(key++));
                        }
                        obj.notifyAll();
                        try {
                            obj.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();





    }




}
