package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yinjie on 2020/6/7
 */
@Data
@ApiModel("个人得分记录")
public class IntegralRecord implements Serializable {
    @ApiModelProperty("时间")
    private Date createDate;
    @ApiModelProperty("得分")
    private Integer score;
    @ApiModelProperty("活动")
    private String name;
    @ApiModelProperty("具体活动")
    private String activity;
    @ApiModelProperty("科目名字")
    private String courseName;
}
