package com.example.demo.frame.ioc.baseconfigration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Nanaan
 * @Date 2024/12/4 21:22
 * @Description
 */
@Configuration
public class Bean4Configuration {
    @Bean
    public Pojo4Configuration createPojoBean() {
        Pojo4Configuration pojo = new Pojo4Configuration();
        pojo.setPojoName("默认名字");
        return pojo;
    }

    @Bean(value = "service")
    public Service4Configuration createServiceBean() {
        return new Service4Configuration();
    }
}
