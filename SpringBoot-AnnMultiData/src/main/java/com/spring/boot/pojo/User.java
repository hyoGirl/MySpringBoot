package com.spring.boot.pojo;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
@Table(name = "t_user")
@Data
public class User implements Serializable{

	private static final long serialVersionUID = 5246561112964655929L;

	@Column(name = "t_id")
	private Long id;

	@Column(name = "t_name")
    private String name;
	
	@Column(name = "t_age")
    private int age;

	@Column(name = "t_address")
    private String address;

	@Column(name = "t_pwd")
    private String pwd;

	private String sex;

}
