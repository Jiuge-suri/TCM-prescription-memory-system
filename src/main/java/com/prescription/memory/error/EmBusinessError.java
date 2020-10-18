package com.prescription.memory.error;

public enum EmBusinessError implements CommonError{
    //前后端交互，提前 约定好响应码
    //通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    NOTFIND(10003,"查询结果为空"),
    //以20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在"),
    PARENT_NOT_EXIST(2004,"外键无对应的值"),
    PRIMARY_KEY_EXIST(20002,"主键冲突"),
    USER_Login_Fail(20003,"用户账号,密码或者职位不正确"),
    LOGINOUTTIME(30001,"登录状态过期，请重新登录"),
    NOTALLOWDELETE(3002,"请先删除与该数据所对应的其他的值"),
    ERROR_PERMISSION_DENIED(403,"权限错误"),
    ERROR_FILE_NOT_FOUND(404,"未能找到"),
    ERROR_HBASE(500,"hbase发生错误"),
    ERROR_HDFS(501,"hdfs发出错误"),
    PHONE_TYPE(4001003,"请输入正确的手机号"),
    CODE_NUM(4001004,"当日发送已达上限"),
    CODE_VALIDATE(4001008,"验证码已失效请重新获取"),
    CODE_WRONG(4001009,"请输入正确的验证码"),
    ACCOUNT_WRONG(4001010,"该账号未被注册，请先注册"),
    REMOTELOGIN(400101,"您得账户已在异地登录");
    ;

    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
