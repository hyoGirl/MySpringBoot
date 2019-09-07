package com.xulei.redis.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/27 22:51
 * @Version 1.0
 */
public class RandomUtil {


    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String numberChar = "0123456789";


    public static String UUID32(){
        String value= UUID.randomUUID().toString();
        value=value.replaceAll("-","");
        return value;
    }


    public static String generatetr(int length){
        StringBuilder stringBuffer=new StringBuilder("");
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return  stringBuffer.toString();
    }

}
