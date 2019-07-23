package com.xulei.decorator;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/23 21:35
 * @Version 1.0
 */
public class WhiteMianbao implements  Mianbao {

    @Override
    public int getrice() {

        System.out.println("单独的白面包，价格是  5元");
        return 5;
    }
}
