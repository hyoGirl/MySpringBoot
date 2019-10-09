package com.spring.boot.mianshi;



/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/27 10:28
 * @Version 1.0
 */
public class ERfen {

    public static void main(String[] args) {

        int[] arr={1, 3, 4, 5, 6, 7};
        int key=5;
        int position=searchKey(arr,key);
        System.out.println(position);

    }

    private static int searchKey(int[] arr, int key) {
        int low=0;
        int high= arr.length-1;
        int middle=0;
        if(key<arr[low] || key> arr[high] ||low >=high ){
            return -1;
        }
        while(low <=high){
            middle=(low+high)/2;
            if(arr[middle] > key){
                high=middle-1;
            }
            else if(arr[middle] < key){
                low=middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
