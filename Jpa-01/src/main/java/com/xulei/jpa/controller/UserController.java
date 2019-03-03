package com.xulei.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xulei.jpa.dao.UserJPA;
import com.xulei.jpa.domain.MyModel;
import com.xulei.jpa.domain.UserEntity;

@RestController
public class UserController {

	@Autowired
	private UserJPA userJPA;

	@RequestMapping(value = "/list")
	public List<UserEntity> list() {
		return userJPA.findAll();
	}
	@RequestMapping(value = "/test")
	public List<MyModel> listTwo() {
		return userJPA.findUser(1);
	}
	
	

}
