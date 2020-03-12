package com.cah.cahdmsp.entity;

import java.util.Date;

public class Outrecord {
    private Long outrecordId;
    private Long outdrugId;
    private String outdrugName;
    private Integer outdrugNum;
    private Double outdrugPriceall;
    private String outTime;
    private Long outPatient;

    public Long getOutrecordId() {
        return outrecordId;
    }

    public void setOutrecordId(Long outrecordId) {
        this.outrecordId = outrecordId;
    }

    public Long getOutdrugId() {
        return outdrugId;
    }

    public void setOutdrugId(Long outdrugId) {
        this.outdrugId = outdrugId;
    }

    public String getOutdrugName() {
        return outdrugName;
    }

    public void setOutdrugName(String outdrugName) {
        this.outdrugName = outdrugName;
    }

    public Integer getOutdrugNum() {
        return outdrugNum;
    }

    public void setOutdrugNum(Integer outdrugNum) {
        this.outdrugNum = outdrugNum;
    }

    public Double getOutdrugPriceall() {
        return outdrugPriceall;
    }

    public void setOutdrugPriceall(Double outdrugPriceall) {
        this.outdrugPriceall = outdrugPriceall;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Long getOutPatient() {
        return outPatient;
    }

    public void setOutPatient(Long outPatient) {
        this.outPatient = outPatient;
    }
}
