package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties绑定了实体类和yml中的配置类
 * 变量名为一一映射的（不一致则无法正确赋值）
 * 命名规则：Canonical names should be kebab-case ('-' separated), lowercase alpha-numeric characters and must start with a letter
 */
@Component
@ConfigurationProperties(prefix = "pay-in-yml")
@Data
public class Pay {
    private String payId;
}
