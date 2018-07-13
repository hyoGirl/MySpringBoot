package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {
	
	
//	@Value("${com.zyd.type}")
//    private String type="aa";
//
//    @Value("${com.zyd.title}")
//    private String title="bb";
    
    
    @Autowired
    private ProConfig proConfig;
    
    @RequestMapping("/test")
    public String test(){
    	
    	int a=100/0;
//    	Pro p=new Pro();
//    	
//    	p.setTitle(title);
//    	p.setType(type);
    	
//    	Pro p2=new Pro();
//    	p2.setTitle(proConfig.getTitle());
//    	p2.setType(proConfig.getType());
    	
    	String show = proConfig.show(new Pro());
    	
    	
//    	return p.toString()+"  "+show;
    	return show;
    }
}
