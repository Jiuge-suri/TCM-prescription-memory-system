package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="StudentPracticeVo", description="学生闯关考试记录表")
public class StudentPracticeVo implements Serializable {
    @ApiModelProperty(value = "记录编号")
    private Integer practiceId;

    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "关卡（考试等级）编号")
    private String checkpointName;

    @ApiModelProperty(value = "是否通关")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "分数")
    private Integer score;

    @ApiModelProperty(value = "考试类型")
    private Integer type;

    @ApiModelProperty(value = "方案编号")
    private String programmeName;

    @ApiModelProperty(value = "科目编号")
    private String courseName;
}
