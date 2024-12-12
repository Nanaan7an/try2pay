package com.example.demo.frame.ioc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Nanaan
 * @Date 2024/12/12 20:19
 * @Description TODO
 */

public class DiMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.demo.frame.ioc.baseannocation");
        Service4Di service4Di = applicationContext.getBean(Service4Di.class);
        service4Di.methodInDiBean();
    }
}
