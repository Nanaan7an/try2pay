package com.example.demo.common.util;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static com.example.demo.common.util.TypeTransUtil.map2NestedJson;

@SpringBootTest
class TypeTransUtilTest {
    @Test
    void map2NestedJsonTeat() {
        Map<String, String> map = new HashMap<>();
        map.put("person.name", "John Doe");
        map.put("person.age", "30");
        map.put("address.city", "New York");

        JSONObject jsonObject = map2NestedJson(map);
        System.out.println(jsonObject);
    }
}
