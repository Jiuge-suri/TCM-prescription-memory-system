package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "兑换规则的数据集")
public class ExchangeruleInfo implements Serializable {
    @ApiModelProperty(value = "规则名字")
    private String name;
    @ApiModelProperty(value = "兑换需要的积分")
    private Integer score;
    @ApiModelProperty(value = "兑换所得学分")
    private Integer integral;
}
