package com.spring.boot.controller;

public class Pro {
	
	private String type;
	private String title;
	
	
	public Pro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pro(String type, String title) {
		super();
		this.type = type;
		this.title = title;
	}


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
	@Override
	public String toString() {
		return "Pro [type=" + type + ", title=" + title + "]";
	}
	
	
}
