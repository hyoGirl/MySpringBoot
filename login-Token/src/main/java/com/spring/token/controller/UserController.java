package com.spring.token.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.spring.token.model.User;
import com.spring.token.service.UserService;
import com.spring.token.util.JwtUtil;
import com.spring.token.util.SimpleJwtUtil;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{pageName}")
    public ModelAndView toPage(@PathVariable("pageName") String pageName){
        ModelAndView mv=new ModelAndView();
        mv.setViewName(pageName);
        return mv;
    }
	
	
	
	
	@PostMapping("/api/user/login")
	public String login(@RequestParam(value="name",required=true)String name,
			@RequestParam(value="pwd",required=true)String pwd
			,HttpServletResponse response) {
		
		Map<String,Object> responseMap=new HashMap<String,Object>();
		User  user = (User) userService.findUser(name,pwd);
		if(user==null) {
			responseMap.put("msg", "没有该账户");
			responseMap.put("code", 001);
			responseMap.put("data", null);
		}
		
		String token =JwtUtil.createJwt(name, pwd);
//		String token = SimpleJwtUtil.sign(name, pwd);
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("user", user);
		paramMap.put("token", token);
		
		responseMap.put("msg", "操作成功");
		responseMap.put("code", 200);
		responseMap.put("data", JSON.toJSON(paramMap));
		
		Cookie cookie=new Cookie("token", token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		String data = JSON.toJSONString(responseMap);
		return data;
	}
	
	
	@GetMapping("/token")
	public String test() {
		return "hello";
	}

}
