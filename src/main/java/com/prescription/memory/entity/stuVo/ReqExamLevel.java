package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "学生考试相关")
public class ReqExamLevel implements Serializable {
    @ApiModelProperty(value = "返回状态")
    private Integer status;
    @ApiModelProperty(value = "返回信息")
    private String massage;
    @ApiModelProperty(value = "等级信息")
    private List<ExamLevel> levelInfo;
}
