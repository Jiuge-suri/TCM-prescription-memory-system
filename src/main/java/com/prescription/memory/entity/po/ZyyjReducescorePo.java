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
@TableName("zyyj_reducescore")
@ApiModel(value="ZyyjReducescorePo对象", description="")
public class ZyyjReducescorePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设置编号")
    @TableId(value = "reduce_id", type = IdType.AUTO)
    private Integer reduceId;

    @ApiModelProperty(value = "修改日期")
    private Date updatedate;

    @ApiModelProperty(value = "叠加分数")
    private Integer score;

    @ApiModelProperty(value = "初始分数")
    private Integer fristReduce;


}
