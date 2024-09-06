package com.example.demo.exception;

import com.example.demo.enums.ResultCode;
import lombok.Getter;

/**
 * @Author Nanaan
 * @Date 2024/5/31 11:26
 * @Description 自定义业务异常
 */

public class BussException extends RuntimeException {
    @Getter
    private String code;

    @Getter
    private String msg;

    @Getter
    private String desc;

    /*
    各种构造函数，方便灵活调用
     */
    public BussException(String code, String msg, String desc) {
        super(msg);
        this.code = code;
        this.desc = desc;
    }

    public BussException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public BussException(ResultCode resultCode, String msg) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = msg;
    }

}
