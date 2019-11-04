package com.spring.boot.mianshi2;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/12 11:59
 * @Version 1.0
 */
public class ErFen {

    public static void main(String[] args) {

        int[] arr={12, 9, 7, 5, 4, 2, 1};
        int key=twoFind(arr,5);
        System.out.println(key);


    }

    private static int twoFind(int[] arr, int key) {

        int start=0;
        int end=arr.length-1;
        int middle;
        if(key<arr[end] || key> arr[start] ||start >=end ){
            return -1;
        }
        while (start < end){
            middle=(start+end)/2;
            if(arr[middle] > key){
                end=middle-1;
            }else if(arr[middle] < key){
                start=middle+1;
            }else{
                return  middle;
            }
        }
        return -1;

    }

}
