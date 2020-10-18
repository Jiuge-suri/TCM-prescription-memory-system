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
@ApiModel(value="ExamLevelVo", description="考试等级")
public class ExamLevelVo implements Serializable {
    @ApiModelProperty(value = "考试等级编号")
    private Integer levelId;

    @ApiModelProperty(value = "所属考试方案名称")
    private String programName;

    @ApiModelProperty(value = "方案id")
    private String programId;

    @ApiModelProperty(value = "考试等级名")
    private String name;

    @ApiModelProperty(value = "总题目数")
    private Integer totalQuestion;

    @ApiModelProperty(value = "总分数")
    private Integer totalScore;

    @ApiModelProperty(value = "通过分数")
    private Integer passScore;

    @ApiModelProperty(value = "各种难度题目，用；隔开")
    private String questionNum;

    @ApiModelProperty(value = "答题时长")
    private Integer limitTime;
}
