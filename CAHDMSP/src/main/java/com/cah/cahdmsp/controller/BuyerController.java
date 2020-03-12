package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.entity.Buyer;
import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.BuyerService;
import com.cah.cahdmsp.utill.HttpServletRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    // 录入采购人信息
    @RequestMapping("/enterBuyer")
    @ResponseBody
    public Result enterBuyer(HttpServletRequest request) {
        try {
            String buyerName = HttpServletRequestUtil.getString(request, "buyerName");
            String buyerPhone = HttpServletRequestUtil.getString(request, "buyerPhone");
            if(StringUtils.isEmpty(buyerName) || StringUtils.isEmpty(buyerPhone)) {
                return Result.error(CodeMsg.BUYERINFO_EMPTY);
            }
            Buyer buyer = new Buyer();
            buyer.setBuyerName(buyerName);
            buyer.setBuyerPhone(buyerPhone);
            if(buyerService.enterBuyer(buyer) != 1) {
                return Result.error(CodeMsg.ENTERBUYER_FAIL);
            }
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.ENTERBUYER_FAIL);
        }
    }

    // 展示所有采购人信息
    @RequestMapping("/showAllBuyer")
    @ResponseBody
    public EasyUIResult showAllBuyer(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return buyerService.showAllBuyer(page, rows);
    }

    // 获取采购人信息
    @RequestMapping("/getBuyer")
    @ResponseBody
    public Result getBuyer(HttpServletRequest request) {
        try {
            Long buyerId = HttpServletRequestUtil.getLong(request, "buyerId");
            if (buyerId == null) {
                return Result.error(CodeMsg.BUYERID_EMPTY);
            }
            Buyer buyer = buyerService.getBuyer(buyerId);
            if(buyer == null) {
                return Result.error(CodeMsg.BUYER_NOTEXIST);
            } else {
                return Result.success(buyer);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.GETBUYER_FAIL);
        }
    }

    // 修改采购人信息
    @RequestMapping("/modifyBuyer")
    @ResponseBody
    public Result modifyBuyer(HttpServletRequest request) {
        try {
            Long buyerId = HttpServletRequestUtil.getLong(request, "buyerId");
            String buyerPhone = HttpServletRequestUtil.getString(request, "buyerPhone");
            if (buyerId == null) {
                return Result.error(CodeMsg.BUYERID_EMPTY);
            }
            if(StringUtils.isEmpty(buyerPhone)) {
                return Result.error(CodeMsg.BUYERPHONE_EMPTY);
            }
            buyerService.modifyBuyer(buyerId, buyerPhone);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.MODIFYBUYER_FAIL);
        }
    }

    // 删除采购人信息
    @RequestMapping("/destroyBuyer")
    @ResponseBody
    public Result destroyBuyer(HttpServletRequest request) {
        try {
            Long buyerId = HttpServletRequestUtil.getLong(request, "buyerId");
            if (buyerId == null) {
                return Result.error(CodeMsg.BUYERID_EMPTY);
            }
            if(buyerService.canDestoryBuyer(buyerId)) {
                buyerService.destroyBuyer(buyerId);
                return Result.success(null);
            } else {
                return Result.error(CodeMsg.BUYER_ABOUTDRUG);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.DESTROYBUYER_FAIL);
        }
    }
}
