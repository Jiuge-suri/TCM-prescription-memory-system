package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "兑换记录")
public class ExchangeintegralInfo implements Serializable {
    @ApiModelProperty(value = "兑换时间")
    private Date createdate;
    @ApiModelProperty(value = "兑换积分")
    private Integer integral;
    @ApiModelProperty(value = "得到学分")
    private Integer score;
}
