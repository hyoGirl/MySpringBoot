package com.spring.boot.service;

import org.springframework.stereotype.Service;

@Service
public class AdviceService {
	
	/**
	 * 
	 * 说明：测试service异常是否拦截
	 * @return
	 * @author 徐磊
	 * @time：2018年5月24日 下午5:53:02
	 */
	public String getData(){
		
		int a=100/0;
		return "1";
	} 
}
