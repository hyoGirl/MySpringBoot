package com.spring.boot.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 22:10
 * @Version 1.0
 */
public class ThreadTime {

    private static ThreadLocal local=ThreadLocal.withInitial(()->
        new SimpleDateFormat("yyyy-MM-dd")
    );



    private static  ThreadLocal<SimpleDateFormat> timeLocal=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


    public static Date parse(String target){

        try {
            return timeLocal.get().parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }




}
