package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.zyd")
public class ProConfig {
	
	private String type="sdf";
	
	private String title="cvb";
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String show(Pro pro){
		
		pro.setTitle(title);
		pro.setType(type);
		
		return pro.toString();
	}
	
	@Override
	public String toString() {
		return "ProConfig [type=" + type + ", title=" + title + "]";
	}
	
	
}
