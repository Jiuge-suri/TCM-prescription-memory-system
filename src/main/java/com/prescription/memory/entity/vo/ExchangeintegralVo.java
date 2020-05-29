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
@ApiModel(value="ExchangeIntegralVo对象", description="学生积分兑换表")
public class ExchangeintegralVo implements Serializable {
    @ApiModelProperty(value = "积分兑换编号")
    private Integer exchangeId;

    @ApiModelProperty(value = "兑换规则名")
    private String  ruleName;

    @ApiModelProperty(value = "学生姓名")
    private String studentName;

    @ApiModelProperty(value = "兑换日期")
    private Date createdate;

    @ApiModelProperty(value = "得分")
    private Integer score;

    @ApiModelProperty(value = "消耗积分")
    private Integer integral;
}
