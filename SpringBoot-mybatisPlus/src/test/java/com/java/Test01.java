package com.java;

/**
 * @author XULEI
 * @ClassName Test01
 * @description TODO
 * @Date 2020/4/11 18:01
 * @Version 1.0
 */
public class Test01 {


    private static  int num=100;

    public Test01(){
        num++;
    }

    public static void main(String[] args) {

        Test01 test01=new Test01();
        test01.num-=10;
        test01=new Test01();
        System.out.println(test01.num);

    }
}
