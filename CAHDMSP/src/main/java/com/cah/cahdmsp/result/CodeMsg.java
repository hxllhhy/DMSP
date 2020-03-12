package com.cah.cahdmsp.result;

// 错误码
public class CodeMsg {

    private int code;
    private String msg;

    // 通用
    public static final CodeMsg SERVER_ERROR = new CodeMsg(50000, "服务端异常");
    public static final CodeMsg NP_EMPTY = new CodeMsg(50001, "用户名和密码不能为空");

    // 登录
    public static final CodeMsg NAME_NOTEXIST= new CodeMsg(50110, "该用户名不存在");
    public static final CodeMsg PAWD_ERROR = new CodeMsg(50111, "密码错误");
    public static final CodeMsg LOGIN_FAIL = new CodeMsg(50112, "登录失败");

    // 用户管理
    public static final CodeMsg NAME_EXIST = new CodeMsg(50210, "该用户名已存在");
    public static final CodeMsg ADDUSER_FAIL = new CodeMsg(50211, "用户信息添加失败");
    public static final CodeMsg DESTROYUSER_FAIL = new CodeMsg(50212, "用户信息删除失败");

    // 药品
    public static final CodeMsg DRUGINFO_EMPTY = new CodeMsg(50310, "药品信息不能为空");
    public static final CodeMsg ENTERDRUG_FAIL = new CodeMsg(50311, "药品信息录入失败");
    public static final CodeMsg DRUGID_EMPTY = new CodeMsg(50312, "药品编号不能为空");
    public static final CodeMsg DRUG_NOTEXIST = new CodeMsg(50313, "该药品编号不存在");
    public static final CodeMsg GETDRUG_FAIL = new CodeMsg(50314, "药品信息查询失败");
    public static final CodeMsg MODIFYDRUG_FAIL = new CodeMsg(50315, "药品信息修改失败");
    public static final CodeMsg INDRUG_FAIL = new CodeMsg(50316, "药品入库失败");
    public static final CodeMsg OUTDRUG_FAIL = new CodeMsg(50317, "药品出库失败");
    public static final CodeMsg DESTROYDRUG_FAIL = new CodeMsg(50318, "药品信息删除失败");

    // 药厂
    public static final CodeMsg FACTORYINFO_EMPTY = new CodeMsg(50410, "药厂信息不能为空");
    public static final CodeMsg ENTERFACTORY_FAIL = new CodeMsg(50411, "药厂信息录入失败");
    public static final CodeMsg FACTORYID_EMPTY = new CodeMsg(50412, "药厂编号不能为空");
    public static final CodeMsg FACTORY_NOTEXIST = new CodeMsg(50413, "该工厂编号不存在");
    public static final CodeMsg GETFACTORY_FAIL = new CodeMsg(50414, "药厂信息查询失败");
    public static final CodeMsg FACTORYADDRESS_EMPTY = new CodeMsg(50415, "药厂地址不能为空");
    public static final CodeMsg FACTORYPHONE_EMPTY = new CodeMsg(50416, "药厂手机号不能为空");
    public static final CodeMsg MODIFYFACTORY_FAIL = new CodeMsg(50417, "药厂信息修改失败");
    public static final CodeMsg DESTROYFACTORY_FAIL = new CodeMsg(50418, "药厂信息删除失败");
    public static final CodeMsg FACTORY_ABOUTDRUG = new CodeMsg(50419, "药厂信息和某药品相关联,无法删除");

    // 采购人
    public static final CodeMsg BUYERINFO_EMPTY = new CodeMsg(50510, "采购人信息不能为空");
    public static final CodeMsg ENTERBUYER_FAIL = new CodeMsg(50511, "采购人信息录入失败");
    public static final CodeMsg BUYERID_EMPTY = new CodeMsg(50512, "采购人编号不能为空");
    public static final CodeMsg BUYER_NOTEXIST = new CodeMsg(50513, "该采购人编号不存在");
    public static final CodeMsg GETBUYER_FAIL = new CodeMsg(50514, "采购人信息查询失败");
    public static final CodeMsg BUYERPHONE_EMPTY = new CodeMsg(50515, "采购人手机号不能为空");
    public static final CodeMsg MODIFYBUYER_FAIL = new CodeMsg(50516, "采购人信息修改失败");
    public static final CodeMsg DESTROYBUYER_FAIL = new CodeMsg(50517, "采购人信息删除失败");
    public static final CodeMsg BUYER_ABOUTDRUG = new CodeMsg(50518, "采购人信息和某药品相关联,无法删除");


    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
