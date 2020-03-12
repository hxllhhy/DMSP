package com.cah.cahdmsp.service;

import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.entity.User;


public interface UserService {

    // 展示所有用户信息
    EasyUIResult showAllUser(Integer page, Integer rows);

    // 该用户是否存在/存在返回true
    Boolean isExistUserName(String userName);

    // 添加用户
    void addUser(User user);

    // 删除用户
    void destroyUser(String userName);

}
