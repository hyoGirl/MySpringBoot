package com.spring.boot.Jichu;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/2 9:12
 * @Version 1.0
 */
public class Finally002 {
    public static void main(String[] args) {
        int key=getValue();
        System.out.println(key);
    }

    public static int getValue() {
        int key=0;
        try {
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            key=1;
            return key;
        }
    }
}
