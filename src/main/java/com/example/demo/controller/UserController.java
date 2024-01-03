package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public String addUser(User user) {
        userService.addUser(user);
        return "ok";
    }

    /**
     * 查询所有user
     */
    public List<User> queryAllUser() {
        return userService.queryAllUser();
    }

    /**
     * 根据id查找user
     *
     * @param id 记录的id
     * @return 返回修改后的结果
     */
    public User queryUserById(int id) {
        return userService.queryUserById(id);
    }

    /**
     * 修改user
     *
     * @param user 修改的user记录
     * @return 操作影响的行数
     */
    public int changeUser(User user) {
        return userService.changeUser(user);
    }

    /**
     * 删除user记录
     *
     * @param user
     * @return 操作影响的行数
     */
    public int delUser(User user) {
        return userService.delUser(user);
    }

}
