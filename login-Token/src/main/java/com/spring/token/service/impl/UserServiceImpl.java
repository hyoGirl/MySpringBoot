package com.spring.token.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spring.token.mapper.UserMapper;
import com.spring.token.model.User;
import com.spring.token.service.UserService;
import com.spring.token.util.SimpleJwtUtil;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User findUser(String name,String pwd) {
		
		Map<String,Object> resultMap=new HashMap<String,Object>();
		
		
		
		User user = userMapper.findUserByName(name);
		
		if(!StringUtils.isEmpty(user)) {
			String password = user.getPwd();
			if(pwd.equals(password)) {
//				String token = SimpleJwtUtil.sign(user.getName(), user.getPwd());
//				
//				
//				return token;
				return user;
			}
		}
		return null;
	}

}
