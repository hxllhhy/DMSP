package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.entity.User;
import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.LoginService;
import com.cah.cahdmsp.utill.HttpServletRequestUtil;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;


    // 用户登录 保存session
    @RequestMapping("/loginUser")
    @ResponseBody
    public Result loginUser(HttpServletRequest request, HttpSession session) {
        try {
            String userName = HttpServletRequestUtil.getString(request, "userName");
            String passWord = HttpServletRequestUtil.getString(request, "passWord");
            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
                return Result.error(CodeMsg.NP_EMPTY);
            }
            User user = loginService.getUserInfoByUserName(userName);
            if (user == null) {
                return Result.error(CodeMsg.NAME_NOTEXIST);
            } else if (!passWord.equals(user.getPassWord())) {
                return Result.error(CodeMsg.PAWD_ERROR);
            } else {
                session = request.getSession();
                session.setAttribute("loginUser", user);
                return Result.success(user);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.LOGIN_FAIL);
        }
    }

    // 取出seeion
    @RequestMapping("/getLoginName")
    @ResponseBody
    public Result getLoginName(HttpSession session) {
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser == null) {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
        return Result.success(loginUser);
    }

    // 清除session
    @RequestMapping("/logOff")
    @ResponseBody
    public void logOff(HttpSession session) {
        Enumeration em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
    }

}
