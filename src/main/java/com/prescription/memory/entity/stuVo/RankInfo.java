package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "排名个人信息")
public class RankInfo implements Serializable {
    @ApiModelProperty(value = "学生姓名")
    private String stuname;
    @ApiModelProperty(value = "学生所得积分")
    private Integer tscore;
    @ApiModelProperty(value = "排名")
    private Integer rank;
}
