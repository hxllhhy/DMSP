package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.FactoryDao;
import com.cah.cahdmsp.entity.Factory;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.FactoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    FactoryDao factoryDao;

    public int enterFactory(Factory factory) {
        return factoryDao.insertFactoryInfo(factory);
    }


    public EasyUIResult showAllFactory(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Factory> factorys = factoryDao.queryAllFactoryInfo();
        PageInfo<Factory> pageInfo = new PageInfo<Factory>(factorys);
        return new EasyUIResult(pageInfo.getTotal(), factorys);
    }

    public Factory getFactory(Long factoryId) {
        return factoryDao.queryFactoryInfoById(factoryId);
    }

    public void modifyFactory(Long factoryId, String factoryAddress, String factoryPhone) {
        factoryDao.updateFactoryInfoById(factoryId, factoryAddress, factoryPhone);
    }

    public void destroyFactory(Long factoryId) {
        factoryDao.deleteFactoryInfoById(factoryId);
    }

    public Boolean canDestoryFactory(Long factoryId) {
        if(factoryDao.queryDrugNumAboutFactoryById(factoryId) != 0) {
            return false;
        } else {
            return true;
        }
    }
}
