package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/aop")
public class LogController {


    @RequestMapping("/test")
    public  String testMdc(@RequestParam String data){
        return  data;
    }


    @RequestMapping("/test2")
    public  String testSession(HttpServletRequest request,@RequestParam("name") String name){


        HttpSession session = request.getSession();



        // Binds an object to this session, using the name specified. If an object
        // of the same name is already bound to the session, the object is replaced.
        session.setAttribute("AAA",name);
        return  session.getId()+"---->"+session.getAttribute("AAA");
    }
}
