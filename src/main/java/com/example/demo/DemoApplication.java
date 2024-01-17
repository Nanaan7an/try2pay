package com.example.demo;

import com.example.demo.config.ConfigurationConfig;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//标注一个SpringBoot应用
@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        /**
         * 注解@Configuration的类ConfigurationConfig
         * 调用Bean对象定义的方法可以得到相应的Bean对象，多次调用返回同一个Bean对象
         */
        ConfigurationConfig configurationConfig =
                (ConfigurationConfig) context.getBean("configurationConfig");

        User user1 = configurationConfig.sameInstance();
        User user2 = configurationConfig.sameInstance();

        log.info("创建实例的结果是：{}", user1 == user2 ? "true" : "false");
    }

}
