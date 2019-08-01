package com.spring.boot.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/30 22:20
 * @Version 1.0
 */
public class Jdk8 {

    public static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static LocalDate parse(String target){

        return LocalDate.parse(target,DATE_TIME_FORMATTER);
    }

    public static String format(LocalDate target){
        return target.format(DATE_TIME_FORMATTER);
    }

}
