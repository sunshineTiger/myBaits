package com.zh.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)//注解的生命周期为运行时
@Target(ElementType.METHOD)//出现的位置
public @interface Select {
    String value();//用于接收Sql语句
}