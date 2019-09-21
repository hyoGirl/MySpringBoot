package com.xulei.rabbitmq;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/9 20:21
 * @Version 1.0
 */
public class Test001 {


    public static void main(String[] args) {


        String ss="asd";
        String s2="asd";

        System.out.println(ss.equals(s2));


        System.out.println(ss.hashCode());

        Integer a=2;

        System.out.println(a.hashCode());

        Object obj="asd";
        System.out.println(obj.hashCode());


    }



}
