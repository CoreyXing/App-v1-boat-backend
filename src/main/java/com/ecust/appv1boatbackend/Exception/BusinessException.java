package com.ecust.appv1boatbackend.Exception;

import com.ecust.appv1boatbackend.model.enumModel.ResultEnum;

public class BusinessException extends RuntimeException{
    private int code;

    private String errMsg;

    public  BusinessException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.errMsg = resultEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
