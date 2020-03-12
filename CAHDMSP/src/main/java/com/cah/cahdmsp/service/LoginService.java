package com.cah.cahdmsp.service;

import com.cah.cahdmsp.entity.User;

public interface LoginService {

    //通过用户名获取用户信息
    User getUserInfoByUserName(String userName);
}
