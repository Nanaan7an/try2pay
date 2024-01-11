package com.example.demo.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * 注解@PropertySource加载指定的配置文件，用于实体类和配置文件绑定。
 * 由于命名非application.*，故该配置文件不会被自动装配
 */
@Component
@Data
@Validated
public class User {

    //    id为自增，不需要传值
    private Integer userId;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 注解@Email，叫做JSR303校验
     */
    @Email(message = "这里是一个自定义的提示")
    private String email;

    /**
     * uuid
     */
    private String uuid;
}
