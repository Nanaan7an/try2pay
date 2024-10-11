package com.example.demo.controller;

import com.example.demo.common.log.LogAnnotation;
import com.example.demo.enums.ResultCode;
import com.example.demo.exception.BussException;
import com.example.demo.pojo.User;
import com.example.demo.pojo.check.param.CheckParam;
import com.example.demo.pojo.response.Response;
import com.example.demo.pojo.response.ResponseUtil;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Resource
    CheckParam checkParam;

    @LogAnnotation(value = "addUser")
    @RequestMapping("/addUser")
    public Response<User> addUser(User user) {
        Response response = new Response<User>();
        checkParam.checkAddUser(user);
        try {
            user = userService.addUser(user);
            response = ResponseUtil.success(user);
        } catch (Exception e) {
            log.error("新增用户异常", e);
            response = ResponseUtil.error(ResultCode.UNKONW);
        } finally {
            return response;
        }
    }

    /**
     * 查询所有user
     */
    @LogAnnotation(value = "addUser")
    @PostMapping("/queryAllUser")
    public List<User> queryAllUser() {
        return userService.queryAllUser();
    }

    /**
     * 根据id查找user
     *
     * @param user id
     * @return 返回修改后的结果
     */
    @LogAnnotation(value = "queryUserById")
    @PostMapping("/queryUserById")
    public Response<User> queryUserById(@RequestBody User user) {
        Response response = new Response<User>();
        try {
            checkParam.checkQueryUserById(user);
            User respUser = userService.queryUserById(user.getUserId());
            response = ResponseUtil.success(respUser);
        } catch (BussException e) {
            log.error("根据ID查询异常", e);
            response = ResponseUtil.error(e.getCode(), e.getMsg(), "");
        } catch (Exception e) {
            log.error("根据ID查询错误", e);
            response = ResponseUtil.error(ResultCode.UNKONW);
        } finally {
            return response;
        }
    }


    public User queryUserByInfo(User user) {
        return userService.queryUserByInfo(user);
    }

    /**
     * 修改user
     *
     * @param user 修改的user记录
     * @return 操作影响的行数
     */
    @LogAnnotation(value = "changeUser")
    @PostMapping("/changeUser")
    public Response<User> changeUser(@RequestBody User user) {
        Response response = new Response<User>();
        try {
            checkParam.checkChangeUser(user);
            response = ResponseUtil.success(userService.changeUser(user));
        } catch (BussException e) {
            log.error("根据修改用户信息异常", e);
            response = ResponseUtil.error(e.getCode(), e.getMsg(), "");
        } catch (Exception e) {
            log.error("根据修改用户信息错误", e);
            response = ResponseUtil.error(ResultCode.UNKONW);
        } finally {
            return response;
        }
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
