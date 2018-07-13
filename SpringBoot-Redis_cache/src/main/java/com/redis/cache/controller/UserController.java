package com.redis.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.cache.pojo.User;
import com.redis.cache.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	
	public List<User> getUsers(){
		return userService.list();
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable("id")int id){
		return userService.delete(id);
	}
}
