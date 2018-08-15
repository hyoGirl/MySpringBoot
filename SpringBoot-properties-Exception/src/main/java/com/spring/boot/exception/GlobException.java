package com.spring.boot.exception;

import java.util.Arrays;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(-1)
public class GlobException {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMsg notFound(RuntimeException e){
		
		System.out.println("----------------------");
		
//		String exceptionMsg = e.getCause().getMessage();
		String exceptionMsg = e.getMessage();
		
		System.out.println("异常信息是： "+exceptionMsg);
		
		
//		Class<? extends Throwable> className = e.getCause().getClass();
//		
//		System.out.println("异常类是： "+className);
		
		StackTraceElement[] stackTrace = e.getStackTrace();
		
		
		System.out.println("具体异常是："+stackTrace[0]);
		
		String data=stackTrace[0].toString();
		
		String allMesssage = data.substring(0, data.indexOf("("));
		
		String className = allMesssage.substring(0,allMesssage.lastIndexOf("."));
		
		String methodName=allMesssage.substring((allMesssage.lastIndexOf(".")+1),allMesssage.length());
		
		System.out.println("类名是："+className);
		System.out.println("方法名是： "+methodName);
		
		
		
		return new ErrorMsg(ExceptionEnum.REQUEST_NULL.getCode(), ExceptionEnum.REQUEST_NULL.getMessage());
	}

}
