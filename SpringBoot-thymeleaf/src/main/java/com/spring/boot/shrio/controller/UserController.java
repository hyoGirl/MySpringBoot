package com.spring.boot.shrio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.shrio.pojo.User;
import com.spring.boot.shrio.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 
	
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
       
    	User user2 = userService.getUser(user.getName());
    	
    	System.out.println(user2);
    	
    	if(user2!=null){
    		System.out.println(user2.toString());
    		return "index";
    	}
    	return "login";
    }

}
