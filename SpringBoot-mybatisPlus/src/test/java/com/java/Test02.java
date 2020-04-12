package com.java;

/**
 * @author XULEI
 * @ClassName Test02
 * @description TODO
 * @Date 2020/4/11 18:05
 * @Version 1.0
 */
public class Test02 {

    int id=100;

    {
        id=20;
    }
    Test02(){
        id++;
    }

    public static void main(String[] args) {


        System.out.println(new Test02().id);

    }
}
