package com.xulei.decorator;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 21:39
 * @Version 1.0
 */
public class FleshMianbao extends Decorators {


    public FleshMianbao(Mianbao mianbao){
        super(mianbao);
    }

    @Override
    public int getrice() {

        int getrice = super.getrice();
        System.out.println("增加了肉，面包要涨价10元");
        return getrice+10;
    }
}
