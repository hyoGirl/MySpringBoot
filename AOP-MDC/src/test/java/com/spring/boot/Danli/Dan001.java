package com.spring.boot.Danli;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/2 10:19
 * @Version 1.0
 */
public class Dan001 {

    private static volatile Dan001 dan001;

    public static Dan001 getDan001(){
        if (dan001==null){
            synchronized (Dan001.class){
                if(dan001==null){
                    return new Dan001();
                }
            }
        }
        return dan001;
    }
}
