package com.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.mybatis.plus.dao*")
@EnableTransactionManagement
public class MybatisPlusApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MybatisPlusApp.class, args);
	}

}
