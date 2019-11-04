package com.mdc.learn;

import com.mdc.learn.spring.DemoService;
import com.mdc.learn.spring.DemoServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/4 20:21
 * @Version 1.0
 */
@Component
public class TestBean implements InitializingBean {

    @Autowired
    DemoServiceImpl demoService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet开始执行了");
        demoService.sayHello();
    }

    @PostConstruct
    public void show(){

        System.out.println("PostConstruct方法开始执行");
    }

    TestBean(){
        System.out.println("构造函数");
    }


}
