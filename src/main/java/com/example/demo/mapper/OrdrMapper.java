package com.example.demo.mapper;

import com.example.demo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdrMapper {
    /**
     * 插入订单信息
     * @param order 订单信息
     * @return 插入条数
     */
    int add(Order order);
}
