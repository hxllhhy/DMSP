package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugDao {

    // 插入一条药品信息
    int insertDrugInfo(Drug drug);

    // 查询所有药品信息
    List<Drug> queryAllDrugInfo();

    // 通过Id查询药品信息
    Drug queryDrugInfoById(Long drugId);

    // 通过Id修改药品信息
    void updateDrugInfoById(@Param("drugId") Long drugId,
                            @Param("drugPrice") Double drugPrice,
                            @Param("chengFen") String chengFen,
                            @Param("xingZhuang") String xingZhuang,
                            @Param("yongFa") String yongFa,
                            @Param("gongXiao") String gongXiao,
                            @Param("factoryId") Long factoryId,
                            @Param("buyerId") Long buyerId);

    // 通过Id出库药品
    void outDrugNumById(@Param("drugId") Long drugId,
                       @Param("drugNum") Integer drugNum);

    // 通过Id入库药品
    void inDrugNumById(@Param("drugId") Long drugId,
                       @Param("drugNum") Integer drugNum);

    // 通过Id删除药品
    void deleteDrugInfoById(@Param("drugId") Long drug);
}
