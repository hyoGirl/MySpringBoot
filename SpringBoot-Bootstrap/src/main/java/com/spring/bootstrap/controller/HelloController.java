package com.spring.bootstrap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String toPage(Model model,HttpServletRequest request) {
		
		model.addAttribute("name", "world");
		
		request.getSession().setAttribute("aaa", "10000");
		return "hello";
		
		
	}
	
	@RequestMapping("/work")
	public String toWork(HttpServletRequest request,Model model) {
		
		
		String attribute = (String) request.getSession().getAttribute("aaa");
		
		model.addAttribute("work", attribute);
		
		
		return "work";
	}
}
