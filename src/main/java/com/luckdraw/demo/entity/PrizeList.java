package com.luckdraw.demo.entity;

import java.util.Date;

public class PrizeList {
    private Long plId;

    private Long pcId;

    private String plName;

    private String plDetail;

    private Integer plType;

    private Integer plNum;

    private Integer plPutNum;

    private Integer maxPlTime;

    private Double plProbability;

    private Double plHuiProbability;

    private Integer asId;

    private Date plValidStartTime;

    private Date plValidEndTime;

    private Byte plStatus;

    private Date plCreateTime;

    private Long paId;

    private Integer adminUserId;

    private String adminUserName;

    private Integer goldNum;

    private Integer plOverNum;

    private String pcImgUrl;

    private Integer isDefault;

    private Double plBuyProbability;

    private String plExtend;

    private String couponCode;

    private String importCode;

    public Long getPlId() {
        return plId;
    }

    public void setPlId(Long plId) {
        this.plId = plId;
    }

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName == null ? null : plName.trim();
    }

    public String getPlDetail() {
        return plDetail;
    }

    public void setPlDetail(String plDetail) {
        this.plDetail = plDetail == null ? null : plDetail.trim();
    }

    public Integer getPlType() {
        return plType;
    }

    public void setPlType(Integer plType) {
        this.plType = plType;
    }

    public Integer getPlNum() {
        return plNum;
    }

    public void setPlNum(Integer plNum) {
        this.plNum = plNum;
    }

    public Integer getPlPutNum() {
        return plPutNum;
    }

    public void setPlPutNum(Integer plPutNum) {
        this.plPutNum = plPutNum;
    }

    public Integer getMaxPlTime() {
        return maxPlTime;
    }

    public void setMaxPlTime(Integer maxPlTime) {
        this.maxPlTime = maxPlTime;
    }

    public Double getPlProbability() {
        return plProbability;
    }

    public void setPlProbability(Double plProbability) {
        this.plProbability = plProbability;
    }

    public Double getPlHuiProbability() {
        return plHuiProbability;
    }

    public void setPlHuiProbability(Double plHuiProbability) {
        this.plHuiProbability = plHuiProbability;
    }

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public Date getPlValidStartTime() {
        return plValidStartTime;
    }

    public void setPlValidStartTime(Date plValidStartTime) {
        this.plValidStartTime = plValidStartTime;
    }

    public Date getPlValidEndTime() {
        return plValidEndTime;
    }

    public void setPlValidEndTime(Date plValidEndTime) {
        this.plValidEndTime = plValidEndTime;
    }

    public Byte getPlStatus() {
        return plStatus;
    }

    public void setPlStatus(Byte plStatus) {
        this.plStatus = plStatus;
    }

    public Date getPlCreateTime() {
        return plCreateTime;
    }

    public void setPlCreateTime(Date plCreateTime) {
        this.plCreateTime = plCreateTime;
    }

    public Long getPaId() {
        return paId;
    }

    public void setPaId(Long paId) {
        this.paId = paId;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName == null ? null : adminUserName.trim();
    }

    public Integer getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(Integer goldNum) {
        this.goldNum = goldNum;
    }

    public Integer getPlOverNum() {
        return plOverNum;
    }

    public void setPlOverNum(Integer plOverNum) {
        this.plOverNum = plOverNum;
    }

    public String getPcImgUrl() {
        return pcImgUrl;
    }

    public void setPcImgUrl(String pcImgUrl) {
        this.pcImgUrl = pcImgUrl == null ? null : pcImgUrl.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Double getPlBuyProbability() {
        return plBuyProbability;
    }

    public void setPlBuyProbability(Double plBuyProbability) {
        this.plBuyProbability = plBuyProbability;
    }

    public String getPlExtend() {
        return plExtend;
    }

    public void setPlExtend(String plExtend) {
        this.plExtend = plExtend == null ? null : plExtend.trim();
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode == null ? null : importCode.trim();
    }
}