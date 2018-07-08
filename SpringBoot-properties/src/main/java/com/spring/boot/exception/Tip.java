package com.spring.boot.exception;
/**
 * 
 * 说明：返回给前台的提示信息
 * @author 徐磊
 * @time：2018年5月24日 下午3:13:55
 */
public class Tip {
	
	protected int code;
	
	protected String messgae;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	@Override
	public String toString() {
		return "Tip [code=" + code + ", messgae=" + messgae + "]";
	}
	
	
}
