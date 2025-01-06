package com.example.demo.pojo.check.param.impl;

import com.example.demo.pojo.User;
import com.example.demo.pojo.check.group.AddUser;
import com.example.demo.pojo.check.group.ChangeUser;
import com.example.demo.pojo.check.group.QueryUserById;
import com.example.demo.pojo.check.param.CheckParam;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Author Nanaan
 * @Date 2024/5/23 9:47
 * @Description TODO
 */
@Service
public class CheckParamImpl implements CheckParam {
    @Validated(AddUser.class)
    @Override
    public void checkAddUser(@Valid User user) {

    }

    @Validated(ChangeUser.class)
    @Override
    public void checkChangeUser(@Valid User user) {

    }

    @Validated(QueryUserById.class)
    @Override
    public void checkQueryUserById(@Valid User user) {

    }
}
