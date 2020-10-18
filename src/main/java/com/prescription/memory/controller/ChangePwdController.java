package com.prescription.memory.controller;

import com.prescription.memory.entity.ResetPwd;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ChangePwdService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yinjie on 2020/6/4
 */
@RestController
@Api(tags = "修改密码")
public class ChangePwdController extends BaseController{
    @Autowired
    private ChangePwdService service;

    @ApiOperation("判断手机号的格式是否正确，返回验证码")
    @GetMapping("/getCode")
    public CommonreturnType getCode(@ApiParam("手机号") @RequestParam("phone") String phone) throws BusinessException {

        return CommonreturnType.create(service.getCode(phone));
    }
    @ApiOperation("修改密码")
    @PostMapping("/changePwd")
    public CommonreturnType changePwd(@RequestBody ResetPwd resetPwd) throws BusinessException {
        return CommonreturnType.create(service.changePwd(resetPwd));
    }
}
