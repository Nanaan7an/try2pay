package com.example.demo.pojo.response;

import lombok.Data;

/**
 * @Author Nanaan
 * @Date 2024/5/13 15:50
 * @Description 返回结果封装
 */
@Data
public class Response<T> {
    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T body;

    /**
     * 构造函数-正常返回，含响应数据
     *
     * @param code 响应码
     * @param msg  响应信息
     * @param body 响应数据
     */
    public Response(String code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    /**
     * 构造函数-异常返回，不含响应数据
     *
     * @param code 响应码
     * @param msg  响应信息
     */
    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数-异常返回，不含响应数据
     *
     * @param msg 响应信息
     */
    public Response(String msg) {
        this.msg = msg;
    }

    /**
     * 无参构造函数
     */
    public Response() {

    }
}
