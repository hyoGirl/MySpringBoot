package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
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


	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	
}
