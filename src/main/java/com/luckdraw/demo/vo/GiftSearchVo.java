package com.luckdraw.demo.vo;

/**
 * Created by Administrator on 2016/10/27.
 */
public class GiftSearchVo implements java.io.Serializable {

    private long paId;
    private int userId;
    private int offset;
    private int pageSize;

    public long getPaId() {
        return paId;
    }

    public void setPaId(long paId) {
        this.paId = paId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
