package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
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
