package com.xulei.mianshi;

import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 22:57
 * @Version 1.0
 */
public class MaoPao {

    public static void main(String[] args) {


        int[] arr = {10, 25, 65, 1, 32};

        System.out.println(Arrays.toString(arr));


        maopao(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void maopao(int[] arr) {


        /**
         * 冒泡排序的思路就是：
         *
         * 第一轮，第一个与第二个比较  第二个与第三个比较  第三个与第四个比较。两两比较，结果比较大的就放后面。第一轮最大的出来了
         *
         * 第二轮，继续
         * 有的数据再后面的排序已经是完好有序的了  1 3 2 4 5 再第一轮排序的时候，就已经是 1 2 3 4 5 了，
         */
        boolean flag=true;
        for (int i = 0; i <arr.length && flag ; i++) {
            flag=false;
            int temp=0;
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j]<arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
        }
    }
}
