package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("zyyj_exchangeintegral")
@ApiModel(value="ZyyjExchangeintegralPo对象", description="")
public class ZyyjExchangeintegralPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "积分兑换编号")
    @TableId(value = "exchange_id", type = IdType.AUTO)
    private Integer exchangeId;

    @ApiModelProperty(value = "兑换规则编号")
    private Integer ruleId;

    @ApiModelProperty(value = "学生编号")
    private Integer stuId;

    @ApiModelProperty(value = "兑换日期")
    private Date createdate;

    @ApiModelProperty(value = "得分")
    private Integer score;

    @ApiModelProperty(value = "消耗积分")
    private Integer integral;


}
