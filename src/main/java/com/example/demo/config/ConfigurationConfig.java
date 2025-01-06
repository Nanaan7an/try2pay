package com.example.demo.config;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * -@Configuration
 * --1.定义配置类，可替换xml的配置文件，类内包含@Bean注解的方法；
 * --2.作为配置类，带有@Bean注解的方法会被动态代理，调用该方法返回的是同一个实例
 */
@Configuration
@Slf4j
public class ConfigurationConfig {

    @Bean
    public void loadOnStart() {
        log.info("启动时加载");
    }

    /**
     * 配置类中调用 Bean 对象定义方法可得到对应 Bean 对象，即使多次调用，返回的是同一个对象
     * 类注解@Configuration中的Bean对象不是普通对象而是代理对象【默认】
     * 若将相关属性置为false，则Bean对象成为普通对象@Configuration(proxyBeanMethods = false)
     * @return 返回一个对象
     */
    @Bean
    public User sameInstance() {
        return new User();
    }
}
