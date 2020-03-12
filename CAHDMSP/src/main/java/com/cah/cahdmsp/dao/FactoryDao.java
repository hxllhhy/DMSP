package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.Factory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FactoryDao {

    // 插入一条药厂信息
    int insertFactoryInfo(Factory factory);

    // 查询所有药厂信息
    List<Factory> queryAllFactoryInfo();

    // 通过Id查询药厂信息
    Factory queryFactoryInfoById(@Param("factoryId") Long factoryId);

    // 通过Id修改药厂信息
    void updateFactoryInfoById(@Param("factoryId") Long factoryId,
                             @Param("factoryAddress") String factoryAddress,
                             @Param("factoryPhone") String factoryPhone);

    // 通过Id删除药厂信息
    void deleteFactoryInfoById(@Param("factoryId") Long factoryId);

    // 通过Id查询药品表里与之相关的信息数
    Integer queryDrugNumAboutFactoryById(@Param("factoryId") Long factoryId);
}
