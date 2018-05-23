package com.luckdraw.demo.vo;


import com.luckdraw.demo.entity.PrizeList;

/**
 * Created by machenike on 2016/10/12 0012.
 */
public class PrizeListVo extends PrizeList {

    private Integer adminUserId;

    private String adminUserName;

    private String importCode;

    private Long wdlUsedNum;

    private String pcName;

    private String asName;

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Long getWdlUsedNum() {
        return wdlUsedNum;
    }

    public void setWdlUsedNum(Long wdlUsedNum) {
        this.wdlUsedNum = wdlUsedNum;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
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
        this.adminUserName = adminUserName;
    }

}
