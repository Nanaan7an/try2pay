package com.example.demo.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * @PropertySource加载指定的配置文件，用于实体类和配置文件绑定。
 * 由于命名非application.*，故该配置文件不会被自动装配
 */
@Component
@PropertySource(value = "classpath:config/demo.properties")
@Data
@Validated
public class User {

    @Value("${userId}")
    private String userId;

    private Integer age;

    /**
     * @Email，叫做JSR303校验
     */
    @Email(message = "这里是一个自定义的提示")
    private String email;
}
