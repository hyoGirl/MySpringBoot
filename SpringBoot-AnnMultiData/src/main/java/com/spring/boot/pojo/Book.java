package com.spring.boot.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
@Table(name = "book")
public class Book implements Serializable{


	private static final long serialVersionUID = -3580096767806089056L;
	
    @Column(name = "b_id")
	private Long id;
	@Column(name = "b_name")
    private String name;
}
