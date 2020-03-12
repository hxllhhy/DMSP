package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {

    // 通过用户名查询用户信息
    User queryUserInfoByName(@Param("userName") String userName);
}
