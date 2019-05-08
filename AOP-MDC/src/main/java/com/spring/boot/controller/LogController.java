package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class LogController {


    @RequestMapping("/test")
    public  String testMdc(@RequestParam String data){
        return  data;
    }
}
