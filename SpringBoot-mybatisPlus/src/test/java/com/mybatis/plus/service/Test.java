package com.mybatis.plus.service;

import com.alibaba.fastjson.JSON;
import com.mybatis.plus.entity.Plus;

public class Test {
	
	public static void main(String[] args) {
		
		Plus plus=new Plus();
		
		plus.setAddress("AAA");
		plus.setAge(12);
		plus.setName("name01");
		plus.setPwd("pwd01");
		
		
		
		System.out.println(JSON.toJSON(plus));
		
	}

}
