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
@ApiModel(value="ExamProgramVo对象", description="考试方案")
public class ExamProgramVo implements Serializable {
    @ApiModelProperty(value = "考试方案编号")
    private Integer programId;

    @ApiModelProperty(value = "考试方案名")
    private String name;

    @ApiModelProperty(value = "等级数")
    private Integer levelNum;

    @ApiModelProperty(value = "方案创建日期")
    private Date createdate;

}
