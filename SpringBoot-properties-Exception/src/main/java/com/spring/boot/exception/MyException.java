package com.spring.boot.exception;

public class MyException extends RuntimeException{
	
	
	private Integer code;
	
	private String message;
	
	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	//传入自定义的枚举异常类。类里面包含了code和message
	public MyException(ServiceExceptionEnum serviceExceptionEnum){
		this.code=serviceExceptionEnum.getCode();
		this.message=serviceExceptionEnum.getMessage();
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
