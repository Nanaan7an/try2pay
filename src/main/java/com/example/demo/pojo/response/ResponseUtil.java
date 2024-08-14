package com.example.demo.pojo.response;

import com.example.demo.enums.ResultCode;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/5/30 17:28
 * @Description 返回参数工具类，作用是：创建返回对象，重载返回方法，使得在返回时，不需要每次手动创建返回对象并填充返回值。
 * 如
 */
@Component
public class ResponseUtil {

    /**
     * 成功
     *
     * @param data 处理成功返回数据
     * @param <T>  数据类型
     * @return
     */
    public static <T> Response success(T data) {
//        Response response = new Response();
//        response.setCode(ResultEnum.SUCCESS.getCode());
//        response.setMsg(ResultEnum.SUCCESS.getDesc());
//        response.setBody(data);
//        return response;
        /**
         * 定义各种构造函数的方便之处在此体现，可以避免像上面一样写很多代码，实现的功能是一样的
         */
        return new Response<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }

    /**
     * 失败
     *
     * @param result 错误类型枚举
     * @param <T>
     * @return
     */
    public static <T> Response error(ResultCode result) {
        return new Response<>(result.getCode(), result.getDesc());
    }

    /**
     * 失败
     *
     * @param errorMsg 显式的传入错误信息
     * @return
     */
    public static Response error(String errorMsg) {
        return new Response<>(ResultCode.THIRD.getCode(), errorMsg);
    }

    /*
     * 未封装如上的返回方法时，在组装返回结果的时候，需要new一个返回对象并为其赋值。
     * 代码量上差不多，但是调用方法能体现封装。
     */
}
