package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //无实体类时可以使用Map
    @GetMapping("/get")
    public List<Map<String, Object>> getAll() {
        String sql = "select * from table";
        //queryFor*，返回类型，具体看源码
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable String id) {
//        String s = "update table set key1=? ,key2=? where id=" + id;
//        Object[] objects = new Object;
//        objects[0] = "0";
//        objects[1] = "1";
//        jdbcTemplate.update(s, objects);
    }
}
