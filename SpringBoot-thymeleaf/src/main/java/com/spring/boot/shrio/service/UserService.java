package com.spring.boot.shrio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.shrio.mapper.UserMapper;
import com.spring.boot.shrio.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper  userMapper;
	
	public User getUser(String userName){
		User uu=userMapper.findUserByUserName(userName);
		return uu;
	}
}
