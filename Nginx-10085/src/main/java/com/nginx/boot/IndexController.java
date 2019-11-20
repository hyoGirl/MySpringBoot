package com.nginx.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        System.out.println("接受到了请求-----10085");
        return "接受到了请求-----10085";
    }


    @RequestMapping("/get")
    public String getSesseion(HttpServletRequest request){
        HttpSession session = request.getSession();
        String value = (String)session.getAttribute("user");
        return "sessionId:"+session.getId()+" 获取到的数据为:"+value;
    }

    @RequestMapping("/set")
    public String setSesseion(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user","wangwq8");
        return "sessionId:"+session.getId()+" 设置数据成功";
    }
}
