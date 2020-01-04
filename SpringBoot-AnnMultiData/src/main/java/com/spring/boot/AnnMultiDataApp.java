package com.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.spring.boot.mapper.book","com.spring.boot.mapper.user"})
public class AnnMultiDataApp {
	
	public static void main(String[] args) {
		SpringApplication.run(AnnMultiDataApp.class, args);
	}

}
