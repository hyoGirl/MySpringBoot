package com.spring.boot.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName LocalUtil
 * @description TODO
 * @Date 2019/5/13 21:40
 * @Version 1.0
 */
public class LocalUtil {

    final static ThreadLocal<Map<String, String>> copyOnThreadLocal = new ThreadLocal<Map<String, String>>();



    public static void put(String key, String val){
        System.out.println(key+"-->"+ val);
        set();
        Map<String, String> map = copyOnThreadLocal.get();
        map.put(key, val);
    }

    public static String get(String key){
        Map<String, String> map = copyOnThreadLocal.get();
        return map.get(key);
    }


    public static void set(){

        Map<String, String> newMap = Collections.synchronizedMap(new HashMap<String, String>());
        copyOnThreadLocal.set(newMap);
    }



    public static void clear(){
        copyOnThreadLocal.remove();
    }


}
