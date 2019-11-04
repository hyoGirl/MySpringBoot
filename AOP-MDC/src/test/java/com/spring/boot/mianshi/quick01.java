package com.spring.boot.mianshi;

import java.util.SortedMap;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/31 8:57
 * @Version 1.0
 */
public class quick01 {


    public static void main(String[] args) {

        int[] arr = {1, 7, 3, 5, 4, 6};

        quick(arr,0,arr.length-1);



    }

    private static void quick(int[] arr, int left, int right) {


        int key=0;

        if(left< right){

            key=sort(arr,left,right);

        }



    }

    private static int sort(int[] arr, int left, int right) {

        int key=arr[left];

        while(left<right){

            while(left<right && arr[right] >=key){
                right--;
            }
            arr[left]=arr[right];
            while(left<right && arr[left] <key){
                left++;
            }
            arr[left]=arr[right];


        }

        return 0;


    }
}
