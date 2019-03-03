package com.xulei.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class MyModel implements Serializable{

	@Column(name = "t_name")
	private String name;

	

	@Column(name = "t_address")
	private String address;



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "MyModel [name=" + name + ", address=" + address + "]";
	}



	public MyModel(String address, String name ) {
		super();
		this.name = name;
		this.address = address;
	}

	
	
	
	
}
