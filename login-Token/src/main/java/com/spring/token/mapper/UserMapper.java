package com.spring.token.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.token.model.User;

public interface UserMapper {
	
	
	User findUserByName(String name);

}
