package com.prescription.memory.entity.stuVo;

import com.prescription.memory.entity.vo.StudentVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "学生个人信息")
public class ReqPersonInfo implements Serializable {
    @ApiModelProperty(value = "学生姓名")
    private String stuName;
    @ApiModelProperty(value = "学生专业")
    private String stuMajor;
    @ApiModelProperty(value = "所在学院")
    private String stuCollege;
    @ApiModelProperty(value = "学号")
    private String stuAccount;
    @ApiModelProperty(value = "学生班级")
    private String stuClass;
    @ApiModelProperty(value = "头像")
    private String photo;
}
