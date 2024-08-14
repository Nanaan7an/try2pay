package com.example.demo.service.impl;

import com.example.demo.enums.ResultCode;
import com.example.demo.exception.BussException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User addUser(User user) {
        UUID uuid=UUID.randomUUID();
        user.setUuid(uuid.toString());
        log.info("生成的uuid为{}", uuid);
        if (userMapper.addUser(user) < 1) {
            throw new BussException(ResultCode.EXISTED, "该用户已存在，请勿重复创建");
        }
        return user;
    }

    @Override
    public List<User> queryAllUser() {
        log.info("查询方法执行前");
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByInfo(User user) {
        return userMapper.queryUserByInfo(user);
    }

    @Override
    public int changeUser(User user) {
        return userMapper.changeUser(user);
    }

    @Override
    public int delUser(User user) {
        return userMapper.delUser(user);
    }
}
