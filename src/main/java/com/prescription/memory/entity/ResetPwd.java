package com.prescription.memory.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/6/5
 */
@ApiModel("重置密码")
@Data
public class ResetPwd implements Serializable {
    @ApiModelProperty("id号")
    private Integer id;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("验证码")
    private String code;

    @ApiModelProperty("新密码")
    private String newPwd;

    @ApiModelProperty("角色id")
    private Integer postId;
}
