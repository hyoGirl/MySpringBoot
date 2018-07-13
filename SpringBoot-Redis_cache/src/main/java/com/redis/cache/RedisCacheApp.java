package com.redis.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.redis.cache.mapper")
public class RedisCacheApp {
	
	public static void main(String[] args) {
		
		SpringApplication.run(RedisCacheApp.class, args);
	}
}
