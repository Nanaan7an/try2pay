package com.example.demo.common.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间相关的方法类
 */
public class DateUtil {

    private final String FORMATTER = "yyyy-MM-dd";
    private final String FORMATTER2 = "yyyy-MM-dd hh:mm:ss";
    private final String FORMATTER3 = "hh:mm:ss";


    /**
     * 获取当前日期
     *
     * @return 当前日期格式化
     */
    public String getDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间格式化
     */
    public String getTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER3);
        return localTime.format(dateTimeFormatter);
    }

    /**
     * 获取毫秒数
     *
     * @return 毫秒数
     */
    public Long getMillisecond() {
        return System.currentTimeMillis();
    }
}
