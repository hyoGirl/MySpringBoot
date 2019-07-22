package com.spring.redis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xulei
 * @Date: 2019/7/8 0008 21:32
 * @Description:
 */
public class TestList {

    public static void main(String[] args) {


        List<String> list=new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            list.add("ASDF"+i);
        }

        int noActivesize = list.size();
        int count = noActivesize / 2 + 1;
        int temp = 0;
        int temp2 = 0;
        for (int i = 0; i < count; i++) {
            temp = i * 2;
            temp2 = temp + 2;
            if (temp2 >= noActivesize) {
                temp2 = noActivesize;
            }
            List<String> subList = list.subList(temp, temp2);
            System.out.println(subList);
            if(temp2 >= noActivesize){
                return;
            }
        }

    }


}
