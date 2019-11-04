package com.xulei.design;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/28 11:44
 * @Version 1.0
 */
public class Test004 {


    static AtomicInteger atomicInteger=new AtomicInteger(0);

    static  volatile  boolean fla=false;

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(atomicInteger.get()<20){
                    if(!fla &&(atomicInteger.get()==0 || atomicInteger.incrementAndGet()%2==0) ){
                        System.out.println(Thread.currentThread().getName()+"-->"+atomicInteger.get());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        fla=true;
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(atomicInteger.get()<20){
                    if(fla && atomicInteger.incrementAndGet()%2==1){
                        System.out.println(Thread.currentThread().getName()+"-->"+atomicInteger.get());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        fla=false;
                    }

                }
            }
        },"t2").start();





    }

}
