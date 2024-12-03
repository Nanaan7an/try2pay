package com.example.demo.frame.ioc.basexml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Nanaan
 * @Date 2024/12/3 20:21
 * @Description
 */

public class XmlMain {
    public static void main(String[] args) {

        /*
        手动创建对象，并手动赋值
         */
//        Pojo4Xml pojo4Xml=new Pojo4Xml();
//        pojo4Xml.setName("a name");

        /*
        容器创建对象
         */
        //根据配置文件名构造Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ioc/applicationContext.xml");
        //根据bean的id获取Bean
        System.out.println(applicationContext.getBean("pojo4Xml"));
    }
}
