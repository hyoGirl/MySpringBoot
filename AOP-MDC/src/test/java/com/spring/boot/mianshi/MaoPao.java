package com.spring.boot.mianshi;

import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/27 9:34
 * @Version 1.0
 */
public class MaoPao {


    public static void main(String[] args) {


        /**
         * 冒泡的写法是：
         *
         *
         * 第一个和第二个比较，第二个和第三个比较   第三个和第四个比较 每比较一次，就会出现一个大的。
         *
         *
         * 然后下一轮比较就会少一个，
         *
         *
         * 问题：
         *
         * 第一轮比较完毕后，后面全部都是有序的，
         *
         * 比如：
         *
         *
         * 12345
         *
         * 51234
         *
         *
         */

        int[] arr={1,7,3,5,4,6};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sortArr(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag=false;
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j]<arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
