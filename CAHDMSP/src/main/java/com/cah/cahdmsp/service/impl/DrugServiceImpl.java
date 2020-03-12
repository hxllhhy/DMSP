package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.DrugDao;
import com.cah.cahdmsp.entity.Drug;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.DrugService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugDao drugDao;

    public int enterDrug(Drug drug) {
        return drugDao.insertDrugInfo(drug);
    }

    public EasyUIResult showAllDrug(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Drug> drugs = drugDao.queryAllDrugInfo();
        PageInfo<Drug> pageInfo = new PageInfo<Drug>(drugs);
        return new EasyUIResult(pageInfo.getTotal(), drugs);
    }

    public Drug getDrug(Long drugId) {
        return drugDao.queryDrugInfoById(drugId);
    }

    public void modifyDrug(Long drugId, Double drugPrice,
                           String chengFen, String xingZhuang, String yongFa,
                           String gongXiao, Long factoryId, Long buyerId) {
        drugDao.updateDrugInfoById(drugId, drugPrice,chengFen,
                                xingZhuang, yongFa, gongXiao, factoryId, buyerId);
    }

    public void outDrug(Long drugId, Integer drugNum) {
        drugDao.outDrugNumById(drugId, drugNum);
    }

    public void inDrug(Long drugId, Integer drugNum) {
        drugDao.inDrugNumById(drugId, drugNum);
    }

    public void destroyDrug(Long drugId) {
        drugDao.deleteDrugInfoById(drugId);
    }
}
