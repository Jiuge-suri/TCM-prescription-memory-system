package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "练习记录")
public class ReqPracticeRecord implements Serializable {
    @ApiModelProperty(value = "学号")
    private Integer stuId;
    @ApiModelProperty(value = "日期")
    private Date createTime;
    @ApiModelProperty(value = "分数")
    private Integer score;
}
