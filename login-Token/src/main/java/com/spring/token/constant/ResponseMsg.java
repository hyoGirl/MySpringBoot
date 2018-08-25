package com.spring.token.constant;

public class ResponseMsg {
	
	
	private String msg;
	
	private int code;
	
	private String content;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResponseMsg [msg=" + msg + ", code=" + code + ", content=" + content + "]";
	}
	
	
	
	

}
