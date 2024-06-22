package com.example.demo.frame.generic.method;

import com.example.demo.frame.generic.entity.Goods;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Nanaan
 * @Date 2024/6/8 22:28
 * @Description 管理部门，用于颁发许可证
 */

@Slf4j
public class Management {
    /**
     * 颁发许可证
     * 传入参数时，编译器可以捕获参数的类型
     *
     * @param market ?泛型通配符
     *               extends 上界通配符，默认是Object
     */
    public void beAllowed(Market<? extends Goods> market) {
        market.isAllow = true;
        log.info("{}取得了许可证", market);
    }
}
