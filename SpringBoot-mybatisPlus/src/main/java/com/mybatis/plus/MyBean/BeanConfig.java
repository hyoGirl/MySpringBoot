package com.mybatis.plus.MyBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author XULEI
 * @ClassName BeanConfig
 * @description TODO
 * @Date 2020/4/6 15:15
 * @Version 1.0
 */
@Configuration
@Import(BeanRegister.class)
public class BeanConfig {
}
