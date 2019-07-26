package com.xulei.decorator;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 21:44
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) {

        Mianbao mianbao=new WhiteMianbao();


        System.out.println(mianbao.getrice());

        System.out.println("--------------------------");

        Mianbao m1=new FleshMianbao(mianbao);

        System.out.println(m1.getrice());

        System.out.println("--------------------------");
        Mianbao m2=new EggMianbao(m1);

        System.out.println(m2.getrice());


    }
}
