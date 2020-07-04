package com.xulei.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author XULEI
 * @ClassName WebConfig
 * @description TODO
 * @Date 2020/7/4 9:45
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**上传地址*/
    @Value("${file.upload.path}")    // F://images/
    private String filePath;
    /**显示相对地址*/
    @Value("${file.upload.relative}")  //  images/**
    private String fileRelativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

//        registry.addResourceHandler(fileRelativePath).
//             addResourceLocations("file:/" + filePath);

        String property = System.getProperty("user.dir");

        property=property+ File.separator;
        registry.addResourceHandler("/images/**").
             addResourceLocations("file:/" + property);
        WebMvcConfigurer.super.addResourceHandlers(registry);

    }




//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(fileRelativePath).
//                addResourceLocations("file:/" + filePath);
//    }

}
