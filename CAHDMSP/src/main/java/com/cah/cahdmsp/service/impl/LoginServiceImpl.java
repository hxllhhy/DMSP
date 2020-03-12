package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.LoginDao;
import com.cah.cahdmsp.entity.User;
import com.cah.cahdmsp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User getUserInfoByUserName(String userName) {
        return loginDao.queryUserInfoByName(userName);
    }

}
