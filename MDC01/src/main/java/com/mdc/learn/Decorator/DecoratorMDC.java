package com.mdc.learn.Decorator;

import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName DecoratorMDC
 * @description TODO
 * @Date 2019/6/15 18:18
 * @Version 1.0
 */
public class DecoratorMDC implements Runnable {


    Runnable runnable;

    private final Map<String,String> map;

    public DecoratorMDC(Runnable runnable) {
        this.runnable = runnable;
        this.map= MDC.getCopyOfContextMap();
    }


    /**
     * 获取当前线程的副本，重新设置进去
     */

    @Override
    public void run() {

        for(Map.Entry<String,String> entry:map.entrySet()){
            MDC.put(entry.getKey(),entry.getValue());
        }


        runnable.run();

        for(Map.Entry<String,String> entry:map.entrySet()){
            MDC.remove(entry.getKey());
        }





    }
}
