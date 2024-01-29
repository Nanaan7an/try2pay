package com.example.demo.mapper;

import com.example.demo.pojo.MerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerMapper {
    /**
     * 新增商户信息
     *
     * @param merInfo 商户信息
     * @return 操作影响的行数
     */
    int addMer(MerInfo merInfo);

    /**
     * 删除商户信息
     *
     * @param merInfo 商户信息
     * @return 操作影响的行数
     */
    int delMer(MerInfo merInfo);

    /**
     * 修改商户信息
     *
     * @param merInfo 商户信息
     * @return 操作影响的行数
     */
    int changeMer(MerInfo merInfo);

    /**
     * 查询商户信息
     *
     * @param merInfo 商户信息
     * @return 操作影响的行数
     */
    List<MerInfo> queryMers(MerInfo merInfo);

    /**
     * 查询所有商户信息
     * @return 所有商户信息id
     */
    List<String> queryAllMer();

}
