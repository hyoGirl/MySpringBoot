package com.xulei.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/9 20:21
 * @Version 1.0
 */
public class Test001 {


    public static void main(String[] args) {


//        String ss="asd";
//        String s2="asd";
//
//        System.out.println(ss.equals(s2));
//
//
//        System.out.println(ss.hashCode());
//
//        Integer a=2;
//
//        System.out.println(a.hashCode());
//
//        Object obj="asd";
//        System.out.println(obj.hashCode());

            List<String> list = new ArrayList<>();
//            list.add("1");
//            list.add("2");
            for (int i = 0; i < 5; i++) {
                list.add(i+"");
            }
            for (String item : list) {
                if ("2".equals(item)) {
                    list.remove(item);
                }
            }
            for (String item:list){
                System.out.println(item);
            }

    }

}
