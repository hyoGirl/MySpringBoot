package com.spring.token.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.token.filter.JwtFilter;


@Configuration
public class WebConfig {

	//FilterRegistrationBean 
	
	@Bean
	public FilterRegistrationBean  jwtFilter() {
		
		FilterRegistrationBean filters=new FilterRegistrationBean();
		
		filters.setFilter(new JwtFilter());
//		List urls = new ArrayList();
//		urls.add("/**");
//		filters.setUrlPatterns(urls);
		
		filters.addUrlPatterns("/*");
		
		
		return filters;
	}
	
}
