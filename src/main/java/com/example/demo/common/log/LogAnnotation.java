package com.example.demo.common.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
自定义注解需要使用元注解修饰。
@Target：注解放置的目标位置/注解使用的范围，如类、方法、属性等。
@Retention注解的生存周期，自定义注解经常使用RetentionPolicy.RUNTIME，始终不会丢弃，程序运行期也保留此注解。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    /*
注解的属性
 */
    String title() default "";
}
