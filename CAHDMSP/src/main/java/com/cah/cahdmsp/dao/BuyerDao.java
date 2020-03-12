package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.Buyer;
import com.cah.cahdmsp.entity.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuyerDao {

    // 插入一条采购人信息
    int insertBuyerInfo(Buyer buyer);

    // 查询所有采购人信息
    List<Buyer> queryAllBuyerInfo();

    // 通过Id查询采购人信息
    Buyer queryBuyerInfoById(@Param("buyerId") Long buyerId);

    // 通过Id修改采购人信息
    void updateBuyerInfoById(@Param("buyerId") Long buyerId,
                             @Param("buyerPhone") String buyerPhone);

    // 通过Id删除采购人信息
    void deleteBuyerInfoById(@Param("buyerId") Long buyerId);

    // 通过Id查询药品表里与之相关的信息数
    Integer queryDrugNumAboutBuyerById(@Param("buyerId") Long buyerId);
}
