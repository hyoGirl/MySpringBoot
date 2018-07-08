package com.redis.cache.mapper;

import java.util.List;

import com.redis.cache.pojo.User;

public interface UserMapper {
	
	
	User findUserByName(String name);
	
	
	boolean deleteUserById(int id);
	
	
	void  updateUser(User user);
	
	void insertUser(User user);
	
	List<User> findAllUser();
}
