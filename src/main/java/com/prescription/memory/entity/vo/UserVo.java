package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="UserVo对象", description="多表查询用户对象")
public class UserVo implements Serializable {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "角色名称")
    private String postName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "用户状态")
    private Integer status;

    @ApiModelProperty(value = "照片url")
    private String photo;
}
