package com.example.demo.exception;

import com.example.demo.enums.ResultCode;
import com.example.demo.pojo.response.Response;
import com.example.demo.pojo.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Nanaan
 * @Date 2024/5/31 15:10
 * @Description 异常处理
 */

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    public Response bussExceptionHandler(BussException e) {
        log.error("BussException", e);
        return ResponseUtil.error(ResultCode.UNKONW);
    }
}