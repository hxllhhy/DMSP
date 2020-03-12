package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.Outrecord;
import com.cah.cahdmsp.result.EasyUIResult;

public interface OutrecordService {

    // 增加一条出库记录
    int addOutrecord(Outrecord outrecord);

    // 展示所有出库记录
    EasyUIResult showAllOutrecord(Integer page, Integer rows);
}
