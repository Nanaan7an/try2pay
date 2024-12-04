package com.example.demo.frame.ioc.baseannocation;

import org.springframework.context.annotation.Configuration;

/**
 * @Author Nanaan
 * @Date 2024/12/4 16:53
 * @Description
 */
@Configuration
public class Service4Annotation {

    public void methodInBean(){
        System.out.println("*** use method in bean created by Configuration ***");
    }
}
