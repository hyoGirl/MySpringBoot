package com.spring.boot.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 22:02
 * @Version 1.0
 */
public class DateUtils {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");

    public static Date parse(String target){

        try {
            return SIMPLE_DATE_FORMAT.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
