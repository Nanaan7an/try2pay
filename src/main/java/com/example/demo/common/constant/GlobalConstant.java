package com.example.demo.common.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/global.properties")
@Data
public class GlobalConstant {


    @Value("${author}")
    private String authorName;

    @Value("${project}")
    private String project;
}
