package com.xulei.mianshi;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 22:08
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {


        int[] agg = {10, 25, 65, 1, 32};

        System.out.println(Arrays.toString(agg));

        quick(agg, 0, agg.length - 1);

        System.out.println(Arrays.toString(agg));

    }

    private static void quick(int[] agg, int left, int right) {

        int temp = 0;
        if (left < right) {
            temp = sort(agg, left, right);
            quick(agg, left, temp - 1);
            quick(agg, temp + 1, right);

        }
    }

    private static int sort(int[] agg, int left, int right) {
        int temp = agg[left];
        while (left < right) {
            while (left < right && agg[right] >= temp) {
                right--;
            }
            //第一步是右边排序。基准值不会变化。把小于的值放一边
            agg[left] = agg[right];
            while (left < right && agg[left] <= temp) {
                left++;
            }
            //第二步基准值还是不变，左边排序，上一步的右边替换后是固定不变的
            agg[right] = agg[left];
        }
        agg[left] = temp;
        return left;
    }


}
