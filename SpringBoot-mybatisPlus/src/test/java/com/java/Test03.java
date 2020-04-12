package com.java;

/**
 * @author XULEI
 * @ClassName Test03
 * @description TODO
 * @Date 2020/4/11 18:07
 * @Version 1.0
 */
public class Test03 {


    int id=100;


    Test03(){
        id++;
    }
    {
        id=20;
    }




    public static void main(String[] args) {


        System.out.println(new Test03().id);

    }
}
