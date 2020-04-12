package com.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EnableAspectJAutoProxy(exposeProxy = true)
public class MybatisPlusApp {




	public static void main(String[] args) {
		
		SpringApplication.run(MybatisPlusApp.class, args);

	}

}
