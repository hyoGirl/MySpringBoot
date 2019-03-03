package com.valid.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.valid.data.peroson.Person;


public class TestData {
	
	public static void main(String[] args) {
		
		
		Person pp=new Person();
		pp.setAge(12);
		pp.setBirthday(new Date());
		pp.setName("张三");
		
		//2000-01-01 00:00:00
		
		Object json = JSON.toJSON(pp);
		
		System.out.println(json);
		Person p2=new Person();
		p2.setAge(12);
		p2.setBirthday(new Date());
		p2.setName("张三");
		
		List list=new ArrayList<Person>();
		
		list.add(p2);
		list.add(pp);
		
		
		System.out.println(JSON.toJSON(list));
		System.out.println(JSON.toJSONString(list));
	}

}
