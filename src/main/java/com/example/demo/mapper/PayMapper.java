package com.example.demo.mapper;

import com.example.demo.pojo.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    /**
     * 插入支付流水
     *
     * @param pay
     * @return
     */
    int add(Pay pay);

    /**
     * 更新支付流水
     *
     * @param pay
     * @return
     */
    int update(Pay pay);

    /**
     * 查询一条支付流水
     *
     * @param pay
     * @return
     */
    Pay query(Pay pay);

    /**
     * 查询多条支付流水
     *
     * @param pay
     * @return
     */
    List<Pay> queryList(Pay pay);
}
