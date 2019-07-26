package com.mdc.learn.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/24 21:16
 * @Version 1.0
 */
public class Context {

    final static ThreadLocal<Map<String, String>> contextThreadLocal = new ThreadLocal<Map<String, String>>();


    public static void put(String key,String value){
        set();
        Map<String, String> map = contextThreadLocal.get();
        map.put(key,value);
    }

    public static String get(String key){
        Map<String, String> map = contextThreadLocal.get();
        return map.get(key);
    }
    private static void set() {
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        contextThreadLocal.set(map);
    }

    public static void clear(){
        contextThreadLocal.remove();
    }

}
