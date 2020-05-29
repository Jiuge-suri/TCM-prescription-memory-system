package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "学生考试信息")
public class ExamLevel implements Serializable {
    @ApiModelProperty(value = "等级id")
    private Integer levelId;
    @ApiModelProperty(value = "方案id")
    private Integer programId;
    @ApiModelProperty(value = "等级名称")
    private String name;
    @ApiModelProperty(value = "题目总数")
    private Integer totalQuestion;
    @ApiModelProperty(value = "总分")
    private Integer totalScore;
    @ApiModelProperty(value = "通关分数")
    private Integer passScore;
    @ApiModelProperty(value = "各种难度题目数")
    private String questionNum;
    @ApiModelProperty(value = "限制时间")
    private Integer limitTime;
}
