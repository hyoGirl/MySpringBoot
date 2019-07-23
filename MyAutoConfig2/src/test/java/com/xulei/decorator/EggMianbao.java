package com.xulei.decorator;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 21:49
 * @Version 1.0
 */
public class EggMianbao extends Decorators{

    public EggMianbao(Mianbao mianbao){
        super(mianbao);
    }

    @Override
    public int getrice() {

        int getrice = super.getrice();
        System.out.println("增加了蛋，面包要涨价5元");
        return getrice+5;
    }
}
