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
@ApiModel(value="StuScoreVo", description="学生积分表")
public class StuScoreVo implements Serializable {
    @ApiModelProperty(value = "积分编号")
    private Integer scoreId;

    @ApiModelProperty(value = "学生名称")
    private String studentName;

    @ApiModelProperty(value = "排名")
    private Integer rank;


    @ApiModelProperty(value = "方案名称")
    private String programmeName;

    @ApiModelProperty(value = "得分")
    private Integer score;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "考核类型")
    private Integer type;
}
