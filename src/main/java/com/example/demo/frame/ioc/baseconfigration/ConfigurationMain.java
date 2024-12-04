package com.example.demo.frame.ioc.baseconfigration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Nanaan
 * @Date 2024/12/4 21:34
 * @Description
 */

public class ConfigurationMain {
    public static void main(String[] args) {
        //1.加载配置类
        //1.1通过类加载
        ApplicationContext applicationContextByClass = new AnnotationConfigApplicationContext(Bean4Configuration.class);
        //1.2【常用】通过扫包加载所有配置类：存在多个配置类的情况下，通过类名获取配置类的操作繁琐
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.demo.frame.ioc.baseconfigration");

        //2.获取Bean
        //2.1配置类中的方法名为默认的bean名称
        System.out.println(applicationContext.getBean("createPojoBean"));
        //2.2通过类获取bean
        System.out.println(applicationContext.getBean(Pojo4Configuration.class));
        //2.3通过@Bean的name或者value的值获取bean
        Service4Configuration service = (Service4Configuration) applicationContext.getBean("service");

        //3.获取到bean后操作对象的属性和方法
        service.methodInBean();
    }
}
