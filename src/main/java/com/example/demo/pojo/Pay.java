package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties绑定了实体类和yml中的配置类
 * 变量名为一一映射的（不一致则无法正确赋值）
 * 命名规则：Canonical names should be kebab-case ('-' separated), lowercase alpha-numeric characters and must start with a letter
 * 支付流水的全生命周期在此记录，包含创建、支付、退款等
 */
@Component
@ConfigurationProperties(prefix = "pay-in-yml")
@Data
public class Pay {
    /**
     * 支付流水号
     */
    private String payId;

    /**
     * 支付流水对应的订单编号
     */
    private String ordrId;

    /**
     * 支付金额
     */
    private String amt;

    /**
     * 支付流水状态，状态枚举见com/example/demo/enums/stateMechine/PayStateEnum.java
     */
    private String paySts;

    /**
     * 商户号
     */
    private String merId;
}
