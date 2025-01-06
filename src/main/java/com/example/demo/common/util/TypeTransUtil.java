package com.example.demo.common.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Nanaan
 * @Date 2024/5/24 20:23
 * @Description 类型转换
 */

public class TypeTransUtil {
    /**
     * 将Map转换为JSON；其中，Map的kay中含有"."，转换出的JSON应当具有嵌套结构。
     * 由于变量名中可以含"."，所以直接转换得到的是一个全部平铺的JSON。
     * 未考虑value也是Map的情形【递归即可】
     *
     * @param map
     * @return
     */
    public static JSONObject map2NestedJson(Map<String, String> map) {
        JSONObject jsonObject = new JSONObject();

        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey();

            JSONObject currentLevel = jsonObject;

            //用“.”作为分隔符，将kay分为几个部分存入数组中，至少含有一个元素
            String[] keys = key.split("\\.");

            //若外层循环的key含“.”则进入内层循环
            for (String currentKey : keys) {
                //若JSON中不包含key的本层级，则将本层级加入到JSON的key中，并为这个key插入一个值，类型是JSON
                //否则，获取key及其值。
                if (!currentLevel.containsKey(currentKey)) {
                    currentLevel.put(currentKey, new JSONObject());
                }
                currentLevel = currentLevel.getJSONObject(currentKey);
            }

            String lastKey = keys[keys.length - 1];
            String value = item.getValue();

            //由于Map的key不重复，则可以保证最后一次循环得到的currentLevel是一个->key：{subKey1:value1,...}
            currentLevel.put(lastKey, value);
        }

        return jsonObject;
    }


    /**
     * Map格式的字符串转换为Map类型
     *
     * @param str
     * @return
     */
    public static Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
}
