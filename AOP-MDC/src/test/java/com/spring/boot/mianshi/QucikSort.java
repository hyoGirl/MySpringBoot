package com.spring.boot.mianshi;

import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/27 9:54
 * @Version 1.0
 */
public class QucikSort {

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 5, 4, 6};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int left, int right) {
        int key = 0;
        if (left < right) {
            key = sort1(arr, left, right);
            quicksort(arr, left, key - 1);
            quicksort(arr, key + 1, right);
        }
    }

    private static int sort1(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] > key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
