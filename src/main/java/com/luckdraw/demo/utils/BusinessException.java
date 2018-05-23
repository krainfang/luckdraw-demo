package com.luckdraw.demo.utils;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code = -1;

    public BusinessException(Object Obj) {
        super(Obj.toString());
    }

    public BusinessException(Integer code, Object obj) {
        super(obj.toString());
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
