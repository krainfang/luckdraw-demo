package com.luckdraw.demo.vo;

/**
 * Created by machenike on 2016/10/17 0017.
 */
public class LuckDrawVo {

    private String paCode;

    private Long paId;

    private Integer userId;

    private String userName;

    private int groupId;

    private String userMobile;

    private int mobileCheck = 0;

    private int isPlatUser = 1;

    private String ipAddress;

    private int asId;

    private String authToken;

    private Double weight;

    private int buy;

    private Integer channel;

    public String getPaCode() {
        return paCode;
    }

    public void setPaCode(String paCode) {
        this.paCode = paCode;
    }

    public Long getPaId() {
        return paId;
    }

    public void setPaId(Long paId) {
        this.paId = paId;
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
        this.userName = userName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public int getMobileCheck() {
        return mobileCheck;
    }

    public void setMobileCheck(int mobileCheck) {
        this.mobileCheck = mobileCheck;
    }

    public int getIsPlatUser() {
        return isPlatUser;
    }

    public void setIsPlatUser(int isPlatUser) {
        this.isPlatUser = isPlatUser;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getAsId() {
        return asId;
    }

    public void setAsId(int asId) {
        this.asId = asId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
