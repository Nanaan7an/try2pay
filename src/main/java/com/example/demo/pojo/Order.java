package com.example.demo.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Order {

    /**
     * 无参构造方法()
     * 有参构造方法()
     * getter()
     * setter()
     * toString()
     */
    @Value("123")
    private String orderId;
}
