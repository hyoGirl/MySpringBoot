package com.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mybatis.plus.dao*")
public class MybatisPlusApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MybatisPlusApp.class, args);
	}

}
