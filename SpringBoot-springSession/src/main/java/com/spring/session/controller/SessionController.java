package com.spring.session.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin") 
public class SessionController {
	
	
	
	/** 放入session进redis */
	
	@GetMapping("/setSession")
	public String setSession(HttpServletRequest request){
		
		request.getSession().setAttribute("LoginUser", "admin");
		request.getSession().setAttribute("AA", "XXX");
		
		
		String requestURI = request.getRequestURI();
		return requestURI;
	}
 
	/** 获取session */
	
	@GetMapping("/getSession")
	public String getSession(HttpServletRequest request){
		
		String attribute = (String) request.getSession().getAttribute("LoginUser");
		String attribute2 = (String) request.getSession().getAttribute("AA");
		
		return attribute + ":" + request.getSession().getId()+":"+attribute2;
		
	}

}
