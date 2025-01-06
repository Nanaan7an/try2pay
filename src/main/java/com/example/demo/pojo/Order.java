package com.example.demo.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

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

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    private String merId;

    /**
     * 用户Id
     */
    @NotBlank(message = "用户Id不能为空")
    private String userId;

    /**
     * 订单金额
     */
    @NotBlank(message = "金额不能为空")
    private String amt;
}
