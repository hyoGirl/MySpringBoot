package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.service.AdviceService;

@RestController
public class AdviceController {
	
	@Autowired
	private AdviceService adviceService;
	
	 @RequestMapping("/ad")
	 public String test(){
	    	
		 String data = adviceService.getData();
	    	
	    	return data;
	    }

}
