package com.spring.boot.mianshi2;

import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/12 11:42
 * @Version 1.0
 */
public class MaoPao {


    public static void main(String[] args) {


        int[] arr={1,4,2,7,9,12,5};
        maopao(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void maopao(int[] arr) {

        int temp=0;
        for (int i = 0; i < arr.length-1; i++) {

            boolean  flag=false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]<arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
//                    temp=arr[j+1];
//                    arr[j+1]=arr[j];
//                    arr[j]=temp;
//                    flag=true;
                }
            }
            if(!flag){
                break;
            }

        }



    }

}
