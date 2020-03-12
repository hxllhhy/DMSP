package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.entity.User;
import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.UserService;
import com.cah.cahdmsp.utill.HttpServletRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // 展示所有用户信息
    @RequestMapping("/showAllUser")
    @ResponseBody
    public EasyUIResult showAllUser(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        EasyUIResult showAllUser = userService.showAllUser(page, rows);
        return showAllUser;
    }

    // 添加新用户
    @RequestMapping("/addUser")
    @ResponseBody
    public Result addUser(HttpServletRequest request) {
        try {
            String userName = HttpServletRequestUtil.getString(request, "userName");
            String passWord = HttpServletRequestUtil.getString(request, "passWord");
            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
                return Result.error(CodeMsg.NP_EMPTY);
            }
            if (userService.isExistUserName(userName)) {
                return Result.error(CodeMsg.NAME_EXIST);
            } else {
                User user = new User();
                user.setUserName(userName);
                user.setPassWord(passWord);
                user.setQuanXian(1);
                userService.addUser(user);
                return Result.success(user);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.ADDUSER_FAIL);
        }
    }

    // 删除用户
    @RequestMapping("/destroyUser")
    @ResponseBody
    public Result destroyUser(HttpServletRequest request) {
        try {
            String userName = HttpServletRequestUtil.getString(request, "userName");
            if (userName == null) {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
            userService.destroyUser(userName);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.DESTROYUSER_FAIL);
        }
    }
}
