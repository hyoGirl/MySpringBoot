package com.xulei.test;

import com.xulei.redis.util.ScriptUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/7 11:01
 * @Version 1.0
 */
public class ScriptTest {

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


    public static void main(String[] args) {
        String sript = getSript("001.txt");
        System.out.println(sript);
    }

}
