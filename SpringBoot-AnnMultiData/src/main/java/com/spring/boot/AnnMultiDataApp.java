package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class AnnMultiDataApp {
	
	public static void main(String[] args) {
		SpringApplication.run(AnnMultiDataApp.class, args);
	}

}
