package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.Drug;
import com.cah.cahdmsp.result.EasyUIResult;

public interface DrugService {
    // 录入药品信息
    int enterDrug(Drug drug);

    // 展示所有药品信息
    EasyUIResult showAllDrug(Integer page, Integer rows);

    // 通过编号获得药品信息
    Drug getDrug(Long drugId);

    // 药品出库
    void outDrug(Long drugId, Integer drugNum);

    // 药品入库
    void inDrug(Long drugId, Integer drugNum);

    // 修改药品信息
    void modifyDrug(Long drugId, Double drugPrice,
                    String chengFen, String xingZhuang, String yongFa,
                    String gongXiao, Long factoryId, Long buyerId);

    // 删除药品信息
    void destroyDrug(Long drugId);
}
