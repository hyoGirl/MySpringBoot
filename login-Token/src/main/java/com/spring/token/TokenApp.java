package com.spring.token;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.token.mapper")
public class TokenApp {

	public static void main(String[] args) {
		
		SpringApplication.run(TokenApp.class, args);
		
	}
}
