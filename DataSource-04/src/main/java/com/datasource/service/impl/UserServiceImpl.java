package com.datasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasource.dao.UserMapper;
import com.datasource.pojo.User;
import com.datasource.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUsers() {
		
		
		return userMapper.findAllUsers();
	}

}
