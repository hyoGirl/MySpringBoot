package com.xulei.redis.util;
import java.io.IOException;
import	java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStream;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/7 10:52
 * @Version 1.0
 */
public class ScriptUtil {

    public static String getSript(String path){
        InputStream resourceAsStream = ScriptUtil.class.getClassLoader().getResourceAsStream(path);
        StringBuilder sb=new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String data;
            while ((data=reader.readLine())!=null){
                sb.append(data).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
