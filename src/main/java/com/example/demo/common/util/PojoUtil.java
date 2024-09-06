package com.example.demo.common.util;

import java.lang.reflect.Field;

/**
 * @Author Nanaan
 * @Date 2024/9/6 14:50
 * @Description TODO
 */

public class PojoUtil {
    /**
     * java反射机制判断对象所有属性是否全部为空
     *
     * @param obj
     * @return true-均不为空
     */
    public static boolean checkObjFieldIsNotNull(Object obj) {
        try {
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(obj) == null || f.get(obj) == "") {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
