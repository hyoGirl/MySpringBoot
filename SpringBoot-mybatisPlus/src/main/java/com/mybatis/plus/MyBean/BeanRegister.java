package com.mybatis.plus.MyBean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author XULEI
 * @ClassName BeanRegister
 * @description 自己实现的注册Bean
 * @Date 2020/4/6 14:56
 * @Version 1.0
 */
//@Component
public class BeanRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition("myService",beanDefinition);

    }
}
