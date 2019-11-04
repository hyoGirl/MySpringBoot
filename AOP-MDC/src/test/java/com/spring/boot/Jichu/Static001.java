package com.spring.boot.Jichu;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/2 9:55
 * @Version 1.0
 */
public class Static001 {

    static int a=100;

    static  void  method(){
        System.out.println("000000");
    }

    public static void main(String[] args) {


        method();

        a=10;

        System.out.println(a);


    }
}
class Demo2{

    static  void  method(){
        System.out.println("12345");
    }
}
