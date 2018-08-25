package com.spring.properties.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="city")
public class DataConfig {

	private Map<String,DataModel> map=new HashMap<>();

	public Map<String, DataModel> getMap() {
		return map;
	}

	public void setMap(Map<String, DataModel> map) {
		this.map = map;
	}
	
	
	 private List<String> list = new ArrayList<>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	 
	 
	 
	
	
	
}
