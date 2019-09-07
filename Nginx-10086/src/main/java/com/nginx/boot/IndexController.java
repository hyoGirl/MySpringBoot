package com.nginx.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/4 21:52
 * @Version 1.0
 */
@RestController
public class IndexController {

    @GetMapping("/test")
    public String nginx(){
        System.out.println("接受到了请求-----10086");
        return "接受到了请求-----10086";
    }
}
