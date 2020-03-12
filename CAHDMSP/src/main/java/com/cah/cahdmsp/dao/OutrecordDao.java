package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.Outrecord;

import java.util.List;

public interface OutrecordDao {

    // 查询所有出库记录
    List<Outrecord> queryAllOutrecord();

    // 插入一条出库记录
    int insertOutrecord(Outrecord outrecord);
}
