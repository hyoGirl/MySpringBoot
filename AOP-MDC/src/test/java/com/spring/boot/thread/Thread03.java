package com.spring.boot.thread;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/10 15:07
 * @Version 1.0
 */
public class Thread03 {


    public static void main(String[] args) {


        Thread02 inatnce = Thread02.getInatnce();
        Thread02 inatnce2 = Thread02.getInatnce();

        System.out.println(inatnce.hashCode()==inatnce2.hashCode());


    }
    private static volatile  Thread03 thread03;
    public static Thread03 getInsance(){
        if(thread03==null){
            synchronized (Thread03.class){
                if(thread03==null){
                    thread03=new Thread03();
                }
            }
        }
        return thread03;
    }

}
