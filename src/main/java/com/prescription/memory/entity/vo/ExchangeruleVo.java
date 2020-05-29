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
@ApiModel(value="ExchangeRuleVo对象", description="积分兑换规则")
public class ExchangeruleVo implements Serializable {
    @ApiModelProperty(value = "规则编号")
    private Integer ruleId;

    @ApiModelProperty(value = "规则名")
    private String name;

    @ApiModelProperty(value = "创建日期")
    private Date createdate;

    @ApiModelProperty(value = "得分")
    private Integer score;

    @ApiModelProperty(value = "消耗积分")
    private Integer integral;

    @ApiModelProperty(value = "是否有效")
    private Integer status;
}
