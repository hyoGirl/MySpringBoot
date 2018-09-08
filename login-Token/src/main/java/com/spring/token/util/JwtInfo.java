package com.spring.token.util;

public class JwtInfo {
	
	
	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	
	public JwtInfo() {
		super();
	}

	public JwtInfo(Long uid) {
		super();
		this.uid = uid;
	}
	
	

}
