package com.mybatis.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/25 21:56
 * @Version 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String test1(){

        return "index";
    }





}
