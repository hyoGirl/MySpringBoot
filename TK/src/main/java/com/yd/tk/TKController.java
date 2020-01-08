package com.yd.tk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/29 20:15
 * @Version 1.0
 */
@RestController
public class TKController {

    @GetMapping("/api/v1")
    public String get1(){

        return "hello----1";
    }

    @GetMapping("/api/v2")
    public String get2(){

        return "hello----2";
    }


}
