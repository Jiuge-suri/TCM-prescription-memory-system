package com.prescription.memory.error;

/**
 * Created by Yinjie on 2020/6/5
 */
public class BusinessException1 extends RuntimeException {
    private final int messageCode;

    private final String detailMessage;

    public BusinessException1(int messageCode, String detailMessage){
        super(detailMessage);
        this.messageCode = messageCode;
        this.detailMessage = detailMessage;
    }

    public int getMessageCode(){
        return messageCode;
    }

    public String getDetailMessage(){
        return detailMessage;
    }
}
