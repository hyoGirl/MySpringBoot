package com.mybatis.plus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_mybatisplus")
public class Plus extends Model<Plus> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private int id;
	
	@TableField("Name")
	private String name;
	
	@TableField("Age")
	private int age;
	
	@TableField("Address")
	private String address;
	
	@TableField("Pwd")
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Plus [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", pwd=" + pwd + "]";
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	
}
