package com.spring.boot.exception;

public enum ExceptionEnum implements ServiceExceptionEnum{
	
	//必须定义一个枚举值，不然会报错
	/**
	 * 错误请求类型
	 */
	SERVER_ERROR(501,"服务器异常"),
	REQUEST_NULL(400,"请求有错误");
	
	
	private String message;  
    private int code;  
    // 构造方法  
    private ExceptionEnum( int code,String message) {  
        this.message = message;  
        this.code = code;  
    }
	@Override
	public Integer getCode() {
		return code;
	}
	@Override
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCode(int code) {
		this.code = code;
	}  

	
    
	
}
