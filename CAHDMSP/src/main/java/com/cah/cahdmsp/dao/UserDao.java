package com.cah.cahdmsp.dao;

import com.cah.cahdmsp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    // 查询所有用户信息
    List<User> queryAllUserInfo();

    // 通过用户名查询用户信息
    User queryUserInfoByName(@Param("userName") String userName);

    // 插入一条用户信息
    void insertUserInfo(User user);

    // 删除一条用户信息
    void deleteUserInfo(@Param("userName") String userName);
}
