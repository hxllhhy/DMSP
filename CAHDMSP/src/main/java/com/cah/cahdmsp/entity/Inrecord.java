package com.cah.cahdmsp.entity;

public class Inrecord {
    private Long inrecordId;
    private Long indrugId;
    private String indrugName;
    private Integer indrugNum;
    private Double indrugPriceall;
    private String inTime;

    public Long getInrecordId() {
        return inrecordId;
    }

    public void setInrecordId(Long inrecordId) {
        this.inrecordId = inrecordId;
    }

    public Long getIndrugId() {
        return indrugId;
    }

    public void setIndrugId(Long indrugId) {
        this.indrugId = indrugId;
    }

    public String getIndrugName() {
        return indrugName;
    }

    public void setIndrugName(String indrugName) {
        this.indrugName = indrugName;
    }

    public Integer getIndrugNum() {
        return indrugNum;
    }

    public void setIndrugNum(Integer indrugNum) {
        this.indrugNum = indrugNum;
    }

    public Double getIndrugPriceall() {
        return indrugPriceall;
    }

    public void setIndrugPriceall(Double indrugPriceall) {
        this.indrugPriceall = indrugPriceall;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }
}
