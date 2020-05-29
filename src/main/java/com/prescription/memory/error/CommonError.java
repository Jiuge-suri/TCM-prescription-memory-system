package com.prescription.memory.error;

public interface CommonError {
    /*获得错误代码*/
    public int getErrCode();
    /*获得错误信息*/
    public String getErrMsg();
    /*设置错误信息*/
    public CommonError setErrMsg(String errMsg);
}
