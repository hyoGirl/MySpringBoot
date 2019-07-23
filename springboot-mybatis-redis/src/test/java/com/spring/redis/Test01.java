package com.spring.redis;

/**
 * @Auther: xulei
 * @Date: 2019/7/8 0008 21:54
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {

        int tmep=0;

        int s1=5001;


        int s2= s1/1000+1;

        int temp=0;
        int temp2=0;

        for (int i = 0; i <s2 ; i++) {

            temp=i*1000;

            temp2=temp+1000;

            if(i!=0){
                temp= i*1000+1;
            }

            if (temp2 >= s1) {
                temp2 = s1;
            }

            System.out.println(temp+"----"+temp2);



        }



    }
}
