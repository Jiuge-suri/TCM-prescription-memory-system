package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="CheckpointVo", description="练习关卡")
public class CheckpointVo implements Serializable {
    @ApiModelProperty(value = "关卡编号")
    private Integer checkpointId;

    @ApiModelProperty(value = "关卡名称")
    private String name;

    @ApiModelProperty(value = "方案id")
    private Integer programmeId;

    @ApiModelProperty(value = "方案名称")
    private String programmeName;

    @ApiModelProperty(value = "限制时间（单位：分钟）")
    private Integer limitTime;

    @ApiModelProperty(value = "各种难题目数，用；隔开")
    private String questionNum;

    @ApiModelProperty(value = "总分")
    private Integer totalScore;

    @ApiModelProperty(value = "通关分数")
    private Integer passScore;

    @ApiModelProperty(value = "备注")
    private String comment;
}
