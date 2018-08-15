package com.datasource.dao;

import java.util.List;

import com.datasource.pojo.User;

public interface UserMapper {
	
	User findUserByUserName(String userName);
	
	
	List<User> findAllUsers();
}
