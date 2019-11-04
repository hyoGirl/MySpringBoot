package com.xulei.design;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/28 11:00
 * @Version 1.0
 */
public class Dan001 {

        private static volatile  Dan001 dan001;
        private Dan001 (){};

        public static Dan001 getDan001(){

            if(dan001==null){
                synchronized (Dan001.class){
                    if(dan001==null){
                        dan001=new Dan001();
                    }
                }
            }
            return dan001;
        }
}
