package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.Inrecord;

import java.util.List;

public interface InrecordDao {

    // 查询所有入库记录
    List<Inrecord> queryAllInrecord();

    // 插入一条入库记录
    int insertInrecord(Inrecord inrecord);
}
