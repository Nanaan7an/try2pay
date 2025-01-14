package com.example.demo.common.aop.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
自定义注解需要使用[元注解]修饰。
@Target：注解放置的目标位置/注解使用的范围，如类、方法、属性等。
@Retention注解的生存周期，自定义注解经常使用RetentionPolicy.RUNTIME，始终不会丢弃，程序运行期也保留此注解。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 注解的属性，格式如下：
     * 属性类型 属性名称();
     * 属性类型 属性名称() default "默认值";
     * 使用时在注解后的括号内声明即可。
     * 若只有一个属性，则一般命名为value，且使用时可以省略属性名直接写属性值。
     * 若有多个属性，则必须指定。
     */
    String value() default "";
}
