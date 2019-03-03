package com.valid.data.peroson;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5888149682255675402L;

	@NotNull
	@Min(value = 1)
	private int age;

	@NotBlank
	private String name;

	@NotNull
	// @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//	@JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")//不成功 {"birthday":" 2001-07-04 12:08:56.235","name":"张三","age":12}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")//keyi
	
//	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//这个可以使用
//	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale = "zh", timezone = "GMT+8")
	private Date birthday;

	// @Valid
	// private PersonList personList;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
