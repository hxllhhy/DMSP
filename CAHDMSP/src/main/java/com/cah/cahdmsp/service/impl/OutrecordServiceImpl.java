package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.OutrecordDao;
import com.cah.cahdmsp.entity.Buyer;
import com.cah.cahdmsp.entity.Outrecord;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.OutrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutrecordServiceImpl implements OutrecordService {

    @Autowired
    OutrecordDao outrecordDao;

    public int addOutrecord(Outrecord outrecord) {
        return outrecordDao.insertOutrecord(outrecord);
    }

    public EasyUIResult showAllOutrecord(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Outrecord> outrecords = outrecordDao.queryAllOutrecord();
        PageInfo<Outrecord> pageInfo = new PageInfo<Outrecord>(outrecords);
        return new EasyUIResult(pageInfo.getTotal(), outrecords);
    }
}
