package com.luckdraw.demo.vo;

import java.util.Date;

/**
 * Created by machenike on 2016/10/11 0011.
 */
public class WinnerListVo {
    private String wlId;

    private String userId;

    private String userName;

    private String userMobile;

    private String ipAddress;

    private String verificationCode;

    private Date wlTime;

    private String wlIsReal;

    private String asName;

    private String plName;

    private String pcName;

    private String joinType;

    private String plType;

    private Long plId;

    public String getWlId() {
        return wlId;
    }

    public void setWlId(String wlId) {
        this.wlId = wlId;
    }

    public String getPlType() {
        return plType;
    }

    public void setPlType(String plType) {
        this.plType = plType;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getWlTime() {
        return wlTime;
    }

    public void setWlTime(Date wlTime) {
        this.wlTime = wlTime;
    }

    public String getWlIsReal() {
        return wlIsReal;
    }

    public void setWlIsReal(String wlIsReal) {
        this.wlIsReal = wlIsReal;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Long getPlId() {
        return plId;
    }

    public void setPlId(Long plId) {
        this.plId = plId;
    }
}
