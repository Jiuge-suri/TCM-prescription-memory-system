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
@TableName("zyyj_exchangerule")
@ApiModel(value="ZyyjExchangerulePo对象", description="")
public class ZyyjExchangerulePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规则编号")
    @TableId(value = "rule_id", type = IdType.AUTO)
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
