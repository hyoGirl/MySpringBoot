package com.mdc.learn.spring;

import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/4 21:00
 * @Version 1.0
 */
@Component
public class DemoServiceImpl implements DemoService {

    String name;

    @Override
    public void setName(String name) {
        System.out.println("正在重新测试"+name);
        this.name=name;
    }

    public void sayHello() {
        System.out.println("hello "+name);
    }

}
