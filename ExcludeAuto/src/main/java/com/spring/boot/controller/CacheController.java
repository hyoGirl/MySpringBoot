package com.spring.boot.controller;

import com.spring.boot.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XULEI
 * @ClassName CacheController
 * @description TODO
 * @Date 2020/4/11 22:13
 * @Version 1.0
 */
@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;


    @GetMapping("/get")
    public String get(){
        String value = cacheService.get("ywy: ");
//        String value = cacheService.get("xxx: ");
        System.out.println("本次从缓存中获取的数据为： "+value);
        return value;
    }

    @GetMapping("/set")
    public void set(){
        cacheService.set("ywy: ","张三");
    }
}
