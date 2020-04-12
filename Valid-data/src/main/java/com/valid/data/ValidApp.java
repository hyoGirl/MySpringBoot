package com.valid.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
public class ValidApp {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ValidApp.class, args);
	}
	
//	@MyBean
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        //1、先定义一个convert转换消息的对象
//        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
//        //2、添加fastjson的配置信息，比如是否要格式化返回的json数据；
//        FastJsonConfig fastJsonConfig=new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //附加：处理中文乱码
//        List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
//        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMedisTypes);
//        //3、在convert中添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter=fastConverter;
//        return new HttpMessageConverters(converter);
//    }
}
