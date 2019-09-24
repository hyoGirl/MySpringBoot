package com.xulei.rabbitmq.annoation;
import	java.lang.annotation.RetentionPolicy;

import groovy.lang.DelegatesTo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/22 10:08
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MQ {

    String value();
}
