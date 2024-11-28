package com.example.demo.frame.thread;

import com.example.demo.exception.BussException;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/11/4 14:21
 * @Description 使用多线程处理List的元素
 */
@Slf4j
@Component
public class Mission4List {

    @Autowired
    UserServiceImpl userServiceImpl;

    public User queryUser(int i) {
        User user = new User();
        try {
            user = userServiceImpl.queryUserById(i);
        } catch (BussException e) {
            log.error("", e);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            return user;
        }
    }


    /**
     * 执行多线程。
     * 在适宜的实际调用此方法，创建线程并运行线程。
     */
    public void exeThread() {
        /*
        这个len有问题，id不是连续的话，会出现：
        1.某个id不存在；
        2.最大id>len。
         */
        int len = userServiceImpl.countUser();
        log.info("当前共有{}个用户", len);
        for (int i = 0; i < 1; i++) {
            ImplRunnable4List implRunnable4List = new ImplRunnable4List("Thread" + i);
            implRunnable4List.start();
        }
    }
}
