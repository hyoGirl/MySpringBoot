package com.xulei.design;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/28 11:09
 * @Version 1.0
 */
public class Dan002 {

    private Dan002 (){}

    private static class Inner{
        static final Dan002 dan002=new Dan002();
    }

    public static Dan002 getDan(){
        return Inner.dan002;
    }

}
