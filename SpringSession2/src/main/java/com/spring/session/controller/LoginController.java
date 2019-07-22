package com.spring.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xulei
 * @Date: 2019/7/18 0018 15:25
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class LoginController {


    @GetMapping("/test1")
    public Map<String,Object> login(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.setAttribute("AA",request.getRequestURI());

        Map<String, Object> map = new HashMap<>();
        map.put("uri",request.getRequestURI());

        return map;
    }

    @GetMapping("/test2")
    public Map<String,Object> get(HttpServletRequest request){

        HttpSession session = request.getSession();


        Object attribute = session.getAttribute("spring:session:sessions " + session.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", session.getAttribute("AA"));
        return map;
    }


}
