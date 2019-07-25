package com.mdc.learn;

import com.mdc.learn.Decorator.DecoratorMDC;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ashura1110
 * @ClassName LogController
 * @description TODO
 * @Date 2019/6/15 17:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/aop")
public class LogController {


    private  final String KEY = "requestId";
    private  final Logger logger = LoggerFactory.getLogger(LogController.class);


    @RequestMapping("/test")
    public  String testMdc(@RequestParam String data){

        try {
            MDC.put(KEY, UUID.randomUUID().toString());
            logger.info(Thread.currentThread().getName()+"---获取到的编号为：--"+MDC.get(KEY));

//            new Thread(()->{
//                MDC.put(KEY, UUID.randomUUID().toString());
//                logger.info(Thread.currentThread().getName()+"---新获取到的编号为：----"+MDC.get(KEY));
//            }).start();

            /**
             * 使用装设者模式来解决
             */

            new Thread(new DecoratorMDC(new Runnable() {
                @Override
                public void run() {
                    logger.info(Thread.currentThread().getName()+"---新获取到的编号为：----"+MDC.get(KEY));
                }
            })).start();


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {

            MDC.remove(KEY);
        }


        return  data;
    }
}
