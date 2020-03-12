package com.cah.cahdmsp.service.impl;

import com.cah.cahdmsp.dao.UserDao;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.entity.User;
import com.cah.cahdmsp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public EasyUIResult showAllUser(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> users = userDao.queryAllUserInfo();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), users);
    }

    public Boolean isExistUserName(String userName) {
        User user = userDao.queryUserInfoByName(userName);
        return user != null;
    }

    public void addUser(User user) {
        userDao.insertUserInfo(user);
    }

    public void destroyUser(String userName) {
        userDao.deleteUserInfo(userName);
    }

}
