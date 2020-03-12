package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.Inrecord;
import com.cah.cahdmsp.result.EasyUIResult;

public interface InrecordService {

    // 增加一条入库记录
    int addInrecord(Inrecord inrecord);

    // 展示所有入库记录
    EasyUIResult showAllInrecord(Integer page, Integer rows);
}
