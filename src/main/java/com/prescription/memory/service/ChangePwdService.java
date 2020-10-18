package com.prescription.memory.service;

import com.prescription.memory.entity.ResetPwd;
import com.prescription.memory.error.BusinessException;

/**
 * Created by Yinjie on 2020/6/5
 */
public interface ChangePwdService {

    public String getCode(String phone) throws BusinessException;

    public String changePwd(ResetPwd resetPwd) throws BusinessException;
}
