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
        /**
         * @param: DemoApplication.class 启动类的类型
         * @param: args String数组，命令行参数，在main方法运行前将参数传入至main；
         *              args可由使用者传入配置选项（如启动参数--key=value）、业务参数等，在不修改代码的前提下，修改输入参数即可满足不同需求。
         *              main方法由JVM调用，故参数由JVM指定，默认情况下数组长度为0。
         *              在idea中，可以在运行配置【Program arguments】中填写需要的参数信息。
         * @return: ConfigurableApplicationContext Spring容器
         */

        SpringApplication.run(DemoApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//
//        /**
//         * 注解@Configuration的类ConfigurationConfig
//         * 调用Bean对象定义的方法可以得到相应的Bean对象，多次调用返回同一个Bean对象
//         */
//        ConfigurationConfig configurationConfig =
//                (ConfigurationConfig) context.getBean("configurationConfig");
//
//        User user1 = configurationConfig.sameInstance();
//        User user2 = configurationConfig.sameInstance();
//
//        log.info("创建实例的结果是：{}", user1 == user2 ? "true" : "false");
    }

}
