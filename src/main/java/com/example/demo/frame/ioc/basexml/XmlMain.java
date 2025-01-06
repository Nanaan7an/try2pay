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
        //1.根据配置文件名(资源路径)读取XML文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ioc/applicationContext.xml");

        //2.获取Bean
        System.out.println(applicationContext.getBean("pojo4Xml"));
        //2.1根据bean的id、要获取的bean的class获取bean
        System.out.println(applicationContext.getBean("pojo4Xml", Pojo4Xml.class).getPojoName());
        //2.2根据bean的id获取bean后，通过强制类型转换得到实际所需的bean类型
        Service4Xml service4Xml = (Service4Xml) applicationContext.getBean("service4Xml");
        //3.获取到正确类型的bean对象后，可以正常操作对象的属性和方法
        service4Xml.methodInBead();
    }
}
