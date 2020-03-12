package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.Buyer;
import com.cah.cahdmsp.result.EasyUIResult;

public interface BuyerService {

    // 录入采购人信息
    int enterBuyer(Buyer buyer);

    // 展示所有采购人信息
    EasyUIResult showAllBuyer(Integer page, Integer rows);

    // 通过编号获取采购人信息
    Buyer getBuyer(Long buyerId);

    // 通过编号修改采购人信息
    void modifyBuyer(Long buyerId, String buyerPhone);

    // 通过编号删除采购人信息
    void destroyBuyer(Long buyerId);

    // 能否删除采购人信息
    Boolean canDestoryBuyer(Long buyerId);
}
