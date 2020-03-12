package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.BaseTest;
import com.cah.cahdmsp.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class LoginDaoTest extends BaseTest {

    @Autowired
    private LoginDao loginDao;

    private static final String userName = "admin";

    @Test
    public void testQueryUserInfoByUserName() throws Exception {
        User user = loginDao.queryUserInfoByName(userName);
        assertEquals("admin", user.getPassWord());
    }
}
