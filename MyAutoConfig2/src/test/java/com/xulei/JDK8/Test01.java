package com.xulei.JDK8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/28 19:58
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) {


        List<String> list=new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("ASDF-->"+i);
        }

        for (int i = 0; i <list.size() ; i++) {
            String data = list.get(i);
            if(data.equals("ASDF-->5")){
                list.remove(data);
            }
        }

//        for (String data: list) {
//            if(data.equals("ASDF-->5")){
//                list.remove(data);
//            }
//
//        }
        System.out.println(list);

    }
}
