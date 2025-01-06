package com.example.demo.frame.ioc.di;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/12/12 20:51
 * @Description
 */
@Data
@Component("pojo4DiByName")
public class Pojo4DiByName {

    @Value("1.60")
    private float height;

    @Value("60")
    private float weight;
}
