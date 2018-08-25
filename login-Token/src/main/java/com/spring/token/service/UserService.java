package com.spring.token.service;

import com.spring.token.model.User;

public interface UserService {
	
	User findUser(String name,String pwd);

}
