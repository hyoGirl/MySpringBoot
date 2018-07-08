package com.spring.boot.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
@Table(name = "t_user")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
