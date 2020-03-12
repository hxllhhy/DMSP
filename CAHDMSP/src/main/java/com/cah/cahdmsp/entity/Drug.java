package com.cah.cahdmsp.entity;

public class Drug {
    private Long drugId;
    private String drugName;
    private Double drugPrice;
    private Integer drugNum;
    private String chengFen;
    private String xingZhuang;
    private String yongFa;
    private String gongXiao;
    private Factory factory;
    private Buyer buyer;

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public String getChengFen() {
        return chengFen;
    }

    public void setChengFen(String chengFen) {
        this.chengFen = chengFen;
    }

    public String getXingZhuang() {
        return xingZhuang;
    }

    public void setXingZhuang(String xingZhuang) {
        this.xingZhuang = xingZhuang;
    }

    public String getYongFa() {
        return yongFa;
    }

    public void setYongFa(String yongFa) {
        this.yongFa = yongFa;
    }

    public String getGongXiao() {
        return gongXiao;
    }

    public void setGongXiao(String gongXiao) {
        this.gongXiao = gongXiao;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
