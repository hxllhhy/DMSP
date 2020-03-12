package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.entity.Factory;
import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.FactoryService;
import com.cah.cahdmsp.utill.HttpServletRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    FactoryService factoryService;

    // 录入药厂信息
    @RequestMapping("/enterFactory")
    @ResponseBody
    public Result enterFactory(HttpServletRequest request) {
        try {
            String factoryName = HttpServletRequestUtil.getString(request, "factoryName");
            String factoryAddress = HttpServletRequestUtil.getString(request, "factoryAddress");
            String factoryPhone = HttpServletRequestUtil.getString(request, "factoryPhone");
            if(StringUtils.isEmpty(factoryName) || StringUtils.isEmpty(factoryPhone) || StringUtils.isEmpty(factoryAddress)) {
                return Result.error(CodeMsg.FACTORYINFO_EMPTY);
            }
            Factory factory = new Factory();
            factory.setFactoryName(factoryName);
            factory.setFactoryAddress(factoryAddress);
            factory.setFactoryPhone(factoryPhone);
            if(factoryService.enterFactory(factory) != 1) {
                return Result.error(CodeMsg.ENTERFACTORY_FAIL);
            }
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.ENTERFACTORY_FAIL);
        }
    }

    // 展示所有药厂信息
    @RequestMapping("/showAllFactory")
    @ResponseBody
    public EasyUIResult showAllFactory(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return factoryService.showAllFactory(page, rows);
    }

    // 获取药厂信息
    @RequestMapping("/getFactory")
    @ResponseBody
    public Result getFactory(HttpServletRequest request) {
        try {
            Long factoryId = HttpServletRequestUtil.getLong(request, "factoryId");
            if (factoryId == null) {
                return Result.error(CodeMsg.FACTORYID_EMPTY);
            }
            Factory factory = factoryService.getFactory(factoryId);
            if(factory == null) {
                return Result.error(CodeMsg.FACTORY_NOTEXIST);
            } else {
                return Result.success(factory);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.GETFACTORY_FAIL);
        }
    }

    // 修改药厂信息
    @RequestMapping("/modifyFactory")
    @ResponseBody
    public Result modifyFactory(HttpServletRequest request) {
        try {
            Long factoryId = HttpServletRequestUtil.getLong(request, "factoryId");
            String factoryAddress = HttpServletRequestUtil.getString(request, "factoryAddress");
            String factoryPhone = HttpServletRequestUtil.getString(request, "factoryPhone");
            if (factoryId == null) {
                return Result.error(CodeMsg.FACTORYID_EMPTY);
            }
            if(StringUtils.isEmpty(factoryAddress)) {
                return Result.error(CodeMsg.FACTORYADDRESS_EMPTY);
            }
            if(StringUtils.isEmpty(factoryPhone)) {
                return Result.error(CodeMsg.FACTORYPHONE_EMPTY);
            }
            factoryService.modifyFactory(factoryId, factoryAddress, factoryPhone);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.MODIFYFACTORY_FAIL);
        }
    }

    // 删除药厂信息
    @RequestMapping("/destroyFactory")
    @ResponseBody
    public Result destroyFactory(HttpServletRequest request) {
        try {
            Long factoryId = HttpServletRequestUtil.getLong(request, "factoryId");
            if (factoryId == null) {
                return Result.error(CodeMsg.FACTORYID_EMPTY);
            }
            if(factoryService.canDestoryFactory(factoryId)) {
                factoryService.destroyFactory(factoryId);
                return Result.success(null);
            } else {
                return Result.error(CodeMsg.FACTORY_ABOUTDRUG);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.DESTROYFACTORY_FAIL);
        }
    }
}
