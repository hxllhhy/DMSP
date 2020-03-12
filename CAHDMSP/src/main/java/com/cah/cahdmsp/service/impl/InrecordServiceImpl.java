package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.InrecordDao;
import com.cah.cahdmsp.entity.Inrecord;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.InrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InrecordServiceImpl implements InrecordService {

    @Autowired
    InrecordDao inrecordDao;

    public int addInrecord(Inrecord inrecord) {
        return inrecordDao.insertInrecord(inrecord);
    }

    public EasyUIResult showAllInrecord(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Inrecord> inrecords = inrecordDao.queryAllInrecord();
        PageInfo<Inrecord> pageInfo = new PageInfo<Inrecord>(inrecords);
        return new EasyUIResult(pageInfo.getTotal(), inrecords);
    }
}
