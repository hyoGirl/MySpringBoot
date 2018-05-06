package com.spring.boot.shrio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.boot.shrio.mapper")
public class ShrioAPP {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ShrioAPP.class, args);
		
	}
}
