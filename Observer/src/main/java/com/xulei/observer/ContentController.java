package com.xulei.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 22:47
 * @Version 1.0
 */
@RestController
public class ContentController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/test")
    public String sendEvent(){
        applicationContext.publishEvent(new ContentEvent(this,"hello"));
        return "world";
    }
}
