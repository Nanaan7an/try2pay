package com.example.demo.pojo;

import com.example.demo.pojo.check.group.AddUser;
import com.example.demo.pojo.check.group.ChangeUser;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 注解@PropertySource加载指定的配置文件，用于实体类和配置文件绑定。
 * 由于命名非application.*，故该配置文件不会被自动装配
 */
@Data
//@Validated
public class User {

    //    id为自增，不需要传值
    @Null(message = "请勿传入userId", groups = {AddUser.class})
    @NotNull(message = "请务必传入userId",groups = {ChangeUser.class})
    private Integer userId;

    /**
     * 用户年龄
     */
    @Min(value = 18, message = "R18")
    private Integer age;

    /**
     * 用户姓名
     */
    @NotBlank(message = "姓名为必填项")
    @Size(max = 20, message = "姓名长度必须不大于20")
    private String userName;

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 100, message = "邮箱长度必须不大于100")
    private String email;

    /**
     * uuid
     */
    @Null(groups = {AddUser.class})
    private String uuid;
}
