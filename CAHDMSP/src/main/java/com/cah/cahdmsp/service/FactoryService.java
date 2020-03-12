package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.Factory;
import com.cah.cahdmsp.result.EasyUIResult;

public interface FactoryService {

    // 录入药厂信息
    int enterFactory(Factory factory);

    // 展示所有药厂信息
    EasyUIResult showAllFactory(Integer page, Integer rows);

    // 通过编号获取药厂信息
    Factory getFactory(Long factoryId);

    // 通过编号修改药厂信息
    void modifyFactory(Long factoryId, String factoryAddress, String factoryPhone);

    // 通过编号删除药厂信息
    void destroyFactory(Long factoryId);

    // 能否删除药厂信息
    Boolean canDestoryFactory(Long factoryId);
}
