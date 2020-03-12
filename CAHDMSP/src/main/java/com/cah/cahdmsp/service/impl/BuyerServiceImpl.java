package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.BuyerDao;
import com.cah.cahdmsp.entity.Buyer;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.BuyerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerDao buyerDao;

    public int enterBuyer(Buyer buyer) {
        return buyerDao.insertBuyerInfo(buyer);
    }

    public EasyUIResult showAllBuyer(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Buyer> buyers = buyerDao.queryAllBuyerInfo();
        PageInfo<Buyer> pageInfo = new PageInfo<Buyer>(buyers);
        return new EasyUIResult(pageInfo.getTotal(), buyers);
    }

    public Buyer getBuyer(Long buyerId) {
        return buyerDao.queryBuyerInfoById(buyerId);
    }

    public void modifyBuyer(Long buyerId, String buyerPhone) {
        buyerDao.updateBuyerInfoById(buyerId, buyerPhone);
    }

    public void destroyBuyer(Long buyerId) {
        buyerDao.deleteBuyerInfoById(buyerId);
    }

    public Boolean canDestoryBuyer(Long buyerId) {
        if (buyerDao.queryDrugNumAboutBuyerById(buyerId) != 0) {
            return false;
        } else {
            return true;
        }
    }
}
