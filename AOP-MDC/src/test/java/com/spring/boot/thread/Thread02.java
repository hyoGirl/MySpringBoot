package com.spring.boot.thread;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/10 15:02
 * @Version 1.0
 */
public class Thread02 {


    private Thread02(){}

    public static class  Inner{

        static  Thread02 thread02=new Thread02();
    }

    public static Thread02 getInatnce(){

        return Inner.thread02;
    }


    public static void main(String[] args) {


//        Thread02 thread02 = new Thread02();
//
//        int hashCode = thread02.hashCode();
//
//
//        Thread02 thread021 = new Thread02();
//
//        int hashCode1 = thread02.hashCode();
//
//
//        System.out.println(hashCode==hashCode1);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread03 insance = Thread03.getInsance();

                    System.out.println(insance.hashCode());
                }
            }).start();
        }
    }

}
