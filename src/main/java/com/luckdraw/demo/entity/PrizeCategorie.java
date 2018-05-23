package com.luckdraw.demo.entity;

import java.util.Date;

public class PrizeCategorie {
    private Long pcId;

    private String pcName;

    private Date pcStartTime;

    private Date pcEndTime;

    private String pcImgUrl;

    private Byte pcStatus;

    private Integer pcSort;

    private Long paId;

    private String pcExtend;

    private Date updateTime;

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName == null ? null : pcName.trim();
    }

    public Date getPcStartTime() {
        return pcStartTime;
    }

    public void setPcStartTime(Date pcStartTime) {
        this.pcStartTime = pcStartTime;
    }

    public Date getPcEndTime() {
        return pcEndTime;
    }

    public void setPcEndTime(Date pcEndTime) {
        this.pcEndTime = pcEndTime;
    }

    public String getPcImgUrl() {
        return pcImgUrl;
    }

    public void setPcImgUrl(String pcImgUrl) {
        this.pcImgUrl = pcImgUrl == null ? null : pcImgUrl.trim();
    }

    public Byte getPcStatus() {
        return pcStatus;
    }

    public void setPcStatus(Byte pcStatus) {
        this.pcStatus = pcStatus;
    }

    public Integer getPcSort() {
        return pcSort;
    }

    public void setPcSort(Integer pcSort) {
        this.pcSort = pcSort;
    }

    public Long getPaId() {
        return paId;
    }

    public void setPaId(Long paId) {
        this.paId = paId;
    }

    public String getPcExtend() {
        return pcExtend;
    }

    public void setPcExtend(String pcExtend) {
        this.pcExtend = pcExtend == null ? null : pcExtend.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}