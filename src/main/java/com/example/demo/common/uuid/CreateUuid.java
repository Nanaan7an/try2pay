package com.example.demo.common.uuid;

import java.util.UUID;

/**
 * 不同的方法生成uuid
 */
public class CreateUuid {
    /**
     * Java类生成
     * 在高并发下可能会下小概率重复
     * 只能生成标准格式
     * @return
     */
    public String JavaUtil(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

//    public String Apache(){
//        UUIDUtil
//    }
}
