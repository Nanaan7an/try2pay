package com.example.demo.enums;

import lombok.Getter;

/**
 * 状态码枚举
 */
public enum ResultCode {

    SUCCESS("00", "成功",""),

    NOT_EXIST("01", "该数据不存在",""),

    EXISTED("02", "该数据已存在，请勿重复请求",""),

    VAILD_FAIL("03","",""),

    CHANGE_FAIL("04", "", ""),

    THIRD("98", "第三方异常",""),

    UNKONW("99", "未知异常",""),
    ;


    /**
     * 状态码
     */
    @Getter
    private String code;

    /**
     * 状态信息
     */
    @Getter
    private String msg;

    /**
     * 状态描述
     */
    @Getter
    private String desc;


    ResultCode(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

}
