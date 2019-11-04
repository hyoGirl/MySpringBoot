package com.spring.boot.Jichu;

import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/1 22:13
 * @Version 1.0
 */
public class Java001 {


    final static int a = 100;
    static int b = 100;

    final static int[] arr = {1, 2, 3, 4};

    public static void main(String[] args) {

        b = 50;
        System.out.println(a);
        System.out.println(b);

        arr[0] = 100;
        System.out.println(Arrays.toString(arr));



        String a1="asdfg";
        String b1=a1;

        a1="SDF";

        System.out.println(a1);
        System.out.println(b1);

        System.out.println(1+1+"AA");

    }


}
