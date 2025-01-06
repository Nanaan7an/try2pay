package com.example.demo.frame.ioc.baseannocation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Nanaan
 * @Date 2024/12/4 22:05
 * @Description
 */

public class AnnotationMain {
    public static void main(String[] args) {
        //1.扫包
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.demo.frame.ioc.baseannocation");
        ///2.获取带@Component的类，若此时尝试获取未使用注解标识的类，则获取不到
        System.out.println(applicationContext.getBean(Pojo4Annotation.class));
        Service4Annotation service = applicationContext.getBean(Service4Annotation.class);
        service.methodInBean();
    }
}
