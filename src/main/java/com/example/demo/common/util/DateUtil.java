package com.example.demo.common.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间相关的方法类
 */
public class DateUtil {

    /**
     * 工具类的构造器方法私有化。
     * 访问静态方法时时通过
     */
    private DateUtil() {
    }

    private static final String DATE1 = "yyyy-MM-dd";
    private static final String DATE2 = "yyyy/MM/dd";
    private static final String DATETIME1 = "yyyy-MM-dd hh:mm:ss";
    private static final String TIME1 = "hh:mm:ss";


    /**
     * 获取当前日期
     *
     * @return 当前日期格式化
     */
    public static String getDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE1);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 获取当前日期时间
     *
     * @return 格式化的日期时间
     */
    public static String getDateTime() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME1);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间格式化
     */
    public static String getTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME1);
        return localTime.format(dateTimeFormatter);
    }

    /**
     * 获取毫秒数
     *
     * @return 毫秒数
     */
    public static Long getMillisecond() {
        return System.currentTimeMillis();
    }

    /**
     * 获取昨天的日期
     *
     * @return 日期格式化
     */
    public static String getPastDay() {
        LocalDate localDate = LocalDate.now().plusDays(-1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME1);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 获取过去的日期。
     * 0-当前日期；1-昨天
     *
     * @param l 以当前为基准的过去的天数
     * @return 日期格式化
     */
    public static String getPastDay(long l) {
        LocalDate localDate = LocalDate.now().plusDays(-l);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME1);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 获取过去的日期，并指定格式化
     *
     * @param l      以当前为基准的过去的天数
     * @param format 指定格式
     * @return 指定的日期格式化
     */
    public static String getPastDay(long l, String format) {
        LocalDate localDate = LocalDate.now().plusDays(-l);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME1);
        return localDate.format(dateTimeFormatter);
    }

}
