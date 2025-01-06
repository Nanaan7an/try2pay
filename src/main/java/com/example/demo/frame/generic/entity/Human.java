package com.example.demo.frame.generic.entity;

import lombok.Data;

/**
 * @Author Nanaan
 * @Date 2024/6/5 17:31
 * @Description 人类，没有继承Goods类，所以不能在商超售出
 */

@Data
public class Human {
    private String name;
}
