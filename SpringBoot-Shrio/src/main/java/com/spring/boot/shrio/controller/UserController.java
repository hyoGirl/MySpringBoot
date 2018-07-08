package com.spring.boot.shrio.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.shrio.pojo.User;

@Controller
public class UserController {
	
	
	
	@GetMapping("/{pageName}")
    public ModelAndView toPage(@PathVariable("pageName") String pageName){

        ModelAndView mv=new ModelAndView();

        mv.setViewName(pageName);

        return mv;
    }
	
	
	//post登录
    @PostMapping("/user/login")
    public String login(User user){
    	System.out.println("---------------");
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                user.getPwd());
        //自动去realm中进行比对，开启shrio控制
        try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "login";
		}
        return "index";
    }

}
