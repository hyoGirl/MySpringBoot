package com.spring.redis;

import java.io.Serializable;

public class Pe implements Serializable,Comparable<Pe>{
	
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int length;
	
	

	public Pe() {
		super();
	}

	public Pe(String name, int length) {
		super();
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Pe [name=" + name + ", length=" + length + "]";
	}

	@Override
	public int compareTo(Pe o) {
		
		int flag=this.getLength()-o.getLength();
		
		if(flag==0){
			flag=this.getName().compareTo(o.getName());
		  }
		
		return flag;
	}
	
	
}
