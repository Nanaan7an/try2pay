package com.example.demo.service;


import com.example.demo.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 新增用户
     */
    int addUser(User user);


    /**
     * 查询所有user
     */
    List<User> queryAllUser();

    /**
     * 根据id查找user
     *
     * @param id 记录的id
     * @return 返回修改后的结果
     */
    User queryUserById(int id);

    /**
     * 根据条件查找User
     * @param user 查询条件
     * @return 查询结果
     */
    User queryUserByInfo(User user);

    /**
     * 修改user
     *
     * @param user 修改的user记录
     * @return 操作影响的行数
     */
    int changeUser(User user);

    /**
     * 删除user记录
     *
     * @param user 删除user的记录
     * @return 操作影响的行数
     */
    int delUser(User user);

}
