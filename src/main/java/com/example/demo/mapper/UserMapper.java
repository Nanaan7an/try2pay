package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface UserMapper {
    /**
     * 新增一条user记录
     *
     * @param user user记录
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
     * @return 返回查询的结果
     */
    User queryUserById(int id);

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
