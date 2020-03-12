package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.entity.*;
import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.result.Result;
import com.cah.cahdmsp.service.*;
import com.cah.cahdmsp.utill.HttpServletRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    DrugService drugService;

    @Autowired
    FactoryService factoryService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    InrecordService inrecordService;

    @Autowired
    OutrecordService outrecordService;

    // 录入药品信息
    @RequestMapping("/enterDrug")
    @ResponseBody
    @Transactional
    public Result enterFactory(HttpServletRequest request) {
        try {
            String drugName = HttpServletRequestUtil.getString(request, "drugName");
            Double drugPrice = HttpServletRequestUtil.getDouble(request, "drugPrice");
            Integer drugNum = HttpServletRequestUtil.getInt(request, "drugNum");
            String chengFen = HttpServletRequestUtil.getString(request, "chengFen");
            String xingZhuang = HttpServletRequestUtil.getString(request, "xingZhuang");
            String yongFa = HttpServletRequestUtil.getString(request, "yongFa");
            String gongXiao = HttpServletRequestUtil.getString(request, "gongXiao");
            Long factoryId = HttpServletRequestUtil.getLong(request, "factoryId");
            Long buyerId = HttpServletRequestUtil.getLong(request, "buyerId");
            if(factoryService.getFactory(factoryId) == null) {
                return Result.error(CodeMsg.FACTORY_NOTEXIST);
            }
            if(buyerService.getBuyer(buyerId) == null) {
                return Result.error(CodeMsg.BUYER_NOTEXIST);
            }
            Drug drug = new Drug();
            Factory factory = new Factory();
            Buyer buyer = new Buyer();
            drug.setDrugName(drugName);
            drug.setDrugPrice(drugPrice);
            drug.setDrugNum(drugNum);
            drug.setChengFen(chengFen);
            drug.setXingZhuang(xingZhuang);
            drug.setYongFa(yongFa);
            drug.setGongXiao(gongXiao);
            factory.setFactoryId(factoryId);
            drug.setFactory(factory);
            buyer.setBuyerId(buyerId);
            drug.setBuyer(buyer);
            if(drugService.enterDrug(drug) != 1) {
                return Result.error(CodeMsg.ENTERBUYER_FAIL);
            }
            Inrecord inrecord = new Inrecord();
            inrecord.setIndrugId(drug.getDrugId());
            inrecord.setIndrugName(drugName);
            inrecord.setIndrugNum(drugNum);
            inrecord.setIndrugPriceall(drugNum*drugPrice);
            inrecord.setInTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inrecordService.addInrecord(inrecord);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.ENTERDRUG_FAIL);
        }
    }


    // 展示所有药品信息
    @RequestMapping("/showAllDrug")
    @ResponseBody
    public EasyUIResult showAllDrug(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return drugService.showAllDrug(page, rows);
    }

    // 获取药品信息
    @RequestMapping("/getDrug")
    @ResponseBody
    public Result getDrug(HttpServletRequest request) {
        try {
            Long drugId = HttpServletRequestUtil.getLong(request, "drugId");
            if (drugId == null) {
                return Result.error(CodeMsg.DRUGID_EMPTY);
            }
            Drug drug = drugService.getDrug(drugId);
            if(drug == null) {
                return Result.error(CodeMsg.DRUG_NOTEXIST);
            } else {
                return Result.success(drug);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.GETDRUG_FAIL);
        }
    }

    // 药品出库
    @RequestMapping("/outDrug")
    @ResponseBody
    @Transactional
    public Result outDrug(HttpServletRequest request) {
        try {
            Long drugId = HttpServletRequestUtil.getLong(request, "drugId");
            String drugName = HttpServletRequestUtil.getString(request, "drugName");
            Integer drugNum = HttpServletRequestUtil.getInt(request, "drugNum");
            Double drugPrice = HttpServletRequestUtil.getDouble(request, "drugPrice");
            Long outPatient = HttpServletRequestUtil.getLong(request, "outPatient");
            if(drugId == null) {
                return Result.error(CodeMsg.DRUGID_EMPTY);
            }
            if(drugNum == null || drugPrice == null || outPatient == null || StringUtils.isEmpty(drugName)) {
                return Result.error(CodeMsg.DRUGINFO_EMPTY);
            }
            drugService.outDrug(drugId, drugNum);
            Outrecord outrecord = new Outrecord();
            outrecord.setOutdrugId(drugId);
            outrecord.setOutdrugName(drugName);
            outrecord.setOutdrugNum(drugNum);
            outrecord.setOutdrugPriceall(drugPrice*drugNum);
            outrecord.setOutPatient(outPatient);
            outrecord.setOutTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            outrecordService.addOutrecord(outrecord);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.OUTDRUG_FAIL);
        }
    }

    // 药品入库
    @RequestMapping("/inDrug")
    @ResponseBody
    @Transactional
    public Result inDrug(HttpServletRequest request) {
        try {
            Long drugId = HttpServletRequestUtil.getLong(request, "drugId");
            Integer drugNum = HttpServletRequestUtil.getInt(request, "drugNum");
            String drugName = HttpServletRequestUtil.getString(request, "drugName");
            Double drugPrice = HttpServletRequestUtil.getDouble(request, "drugPrice");
            if(drugId == null || drugNum == null) {
                return Result.error(CodeMsg.DRUGINFO_EMPTY);
            }
            drugService.inDrug(drugId, drugNum);
            Inrecord inrecord = new Inrecord();
            inrecord.setIndrugId(drugId);
            inrecord.setIndrugName(drugName);
            inrecord.setIndrugNum(drugNum);
            inrecord.setIndrugPriceall(drugNum*drugPrice);
            inrecord.setInTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inrecordService.addInrecord(inrecord);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.INDRUG_FAIL);
        }
    }


    // 修改药品信息
    @RequestMapping("/modifyDrug")
    @ResponseBody
    public Result modifyDrug(HttpServletRequest request) {
        try {
            Long drugId = HttpServletRequestUtil.getLong(request, "drugId");
            Double drugPrice = HttpServletRequestUtil.getDouble(request, "drugPrice");
            String chengFen = HttpServletRequestUtil.getString(request, "chengFen");
            String xingZhuang = HttpServletRequestUtil.getString(request, "xingZhuang");
            String yongFa = HttpServletRequestUtil.getString(request, "yongFa");
            String gongXiao = HttpServletRequestUtil.getString(request, "gongXiao");
            Long factoryId = HttpServletRequestUtil.getLong(request, "factoryId");
            Long buyerId = HttpServletRequestUtil.getLong(request, "buyerId");
            if (drugId == null) {
                return Result.error(CodeMsg.DRUGID_EMPTY);
            }
            if(drugPrice == null || factoryId == null || buyerId == null ||
                    StringUtils.isEmpty(chengFen) || StringUtils.isEmpty(xingZhuang) ||
                    StringUtils.isEmpty(yongFa) || StringUtils.isEmpty(gongXiao)) {
                return Result.error(CodeMsg.DRUGINFO_EMPTY);
            }
            if(factoryService.getFactory(factoryId) == null) {
                return Result.error(CodeMsg.FACTORY_NOTEXIST);
            }
            if(buyerService.getBuyer(buyerId) == null) {
                return Result.error(CodeMsg.BUYER_NOTEXIST);
            }
            drugService.modifyDrug(drugId, drugPrice, chengFen,
                                xingZhuang, yongFa, gongXiao, factoryId, buyerId);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.MODIFYDRUG_FAIL);
        }
    }

    // 删除药品信息
    @RequestMapping("/destroyDrug")
    @ResponseBody
    public Result destroyDrug(HttpServletRequest request) {
        try {
            Long drugId = HttpServletRequestUtil.getLong(request, "drugId");
            if (drugId == null) {
                return Result.error(CodeMsg.DRUGID_EMPTY);
            }
            if(drugService.getDrug(drugId).getDrugNum() > 0) {
                return Result.error(CodeMsg.DESTROYDRUG_FAIL);
            }
            drugService.destroyDrug(drugId);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(CodeMsg.DESTROYDRUG_FAIL);
        }
    }
}
