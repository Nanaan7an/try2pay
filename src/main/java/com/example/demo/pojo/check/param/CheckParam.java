package com.example.demo.pojo.check.param;

import com.example.demo.pojo.User;

/**
 * 参数校验Service
 */
public interface CheckParam {
    /**
     * 增加用户信息参数校验
     *
     * @param user
     */
    void checkAddUser(User user);

    /**
     * 更改用户信息参数校验
     *
     * @param user
     */
    void checkChangeUser(User user);

}
