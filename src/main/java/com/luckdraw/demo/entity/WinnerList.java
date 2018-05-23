package com.luckdraw.demo.entity;

import java.util.Date;

public class WinnerList {
    private Long wlId;

    private Integer userId;

    private String userName;

    private String userMobile;

    private String ipAddress;

    private Long plId;

    private String verificationCode;

    private Date wlTime;

    private Date wlDate;

    private Byte wlIsReal;

    private Long paId;

    private Byte wlIsActive;

    private String wlPlatPhone;

    private String zhifubao;

    private String wlFromId;

    private Byte wlIsSave;

    private Byte wlIsExchange;

    private Integer wlExchangePrizeId;

    private Date wlActiveDate;

    public Long getWlId() {
        return wlId;
    }

    public void setWlId(Long wlId) {
        this.wlId = wlId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Long getPlId() {
        return plId;
    }

    public void setPlId(Long plId) {
        this.plId = plId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode == null ? null : verificationCode.trim();
    }

    public Date getWlTime() {
        return wlTime;
    }

    public void setWlTime(Date wlTime) {
        this.wlTime = wlTime;
    }

    public Date getWlDate() {
        return wlDate;
    }

    public void setWlDate(Date wlDate) {
        this.wlDate = wlDate;
    }

    public Byte getWlIsReal() {
        return wlIsReal;
    }

    public void setWlIsReal(Byte wlIsReal) {
        this.wlIsReal = wlIsReal;
    }

    public Long getPaId() {
        return paId;
    }

    public void setPaId(Long paId) {
        this.paId = paId;
    }

    public Byte getWlIsActive() {
        return wlIsActive;
    }

    public void setWlIsActive(Byte wlIsActive) {
        this.wlIsActive = wlIsActive;
    }

    public String getWlPlatPhone() {
        return wlPlatPhone;
    }

    public void setWlPlatPhone(String wlPlatPhone) {
        this.wlPlatPhone = wlPlatPhone == null ? null : wlPlatPhone.trim();
    }

    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao == null ? null : zhifubao.trim();
    }

    public String getWlFromId() {
        return wlFromId;
    }

    public void setWlFromId(String wlFromId) {
        this.wlFromId = wlFromId == null ? null : wlFromId.trim();
    }

    public Byte getWlIsSave() {
        return wlIsSave;
    }

    public void setWlIsSave(Byte wlIsSave) {
        this.wlIsSave = wlIsSave;
    }

    public Byte getWlIsExchange() {
        return wlIsExchange;
    }

    public void setWlIsExchange(Byte wlIsExchange) {
        this.wlIsExchange = wlIsExchange;
    }

    public Integer getWlExchangePrizeId() {
        return wlExchangePrizeId;
    }

    public void setWlExchangePrizeId(Integer wlExchangePrizeId) {
        this.wlExchangePrizeId = wlExchangePrizeId;
    }

    public Date getWlActiveDate() {
        return wlActiveDate;
    }

    public void setWlActiveDate(Date wlActiveDate) {
        this.wlActiveDate = wlActiveDate;
    }
}