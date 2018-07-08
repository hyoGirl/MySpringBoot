package com.spring.boot.shrio.mapper;

import com.spring.boot.shrio.pojo.User;

public interface UserMapper {
	
	User findUserByUserName(String userName);
	
}
