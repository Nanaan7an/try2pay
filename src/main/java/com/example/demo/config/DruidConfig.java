package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //绑定配置文件
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 后台监控
     * 固定写法
     */
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        /**
         * 可以先调用方法，从方法中获取所需的参数类型（和参数名，因为可以省得自己起名字）
         */

        //配置后台的账密
        Map<String, String> initParameters=new HashMap<>();
        //增加配置，参数是固定的，不可随意发挥
        initParameters.put("loginUsername","username");

        //允许可访问的人
        initParameters.put("allow","");

        //禁止访问

        
        bean.setInitParameters(initParameters);

        return null;

    }
}
