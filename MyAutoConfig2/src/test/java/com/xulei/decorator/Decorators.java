package com.xulei.decorator;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 21:36
 * @Version 1.0
 */
public class Decorators implements Mianbao{


    private Mianbao mianbao;


    Decorators(Mianbao mianbao){
        this.mianbao=mianbao;
    }

    @Override
    public int getrice() {
        return mianbao.getrice();
    }
}
