package com.example.demo.frame.ioc.baseannocation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/12/3 10:02
 * @Description
 */

@Data
@Component
public class Pojo4Annotation {
    private String pojoName = "默认姓名";
    private String tel;
    @Value("10")
    private int age;
    private boolean alive;
}
