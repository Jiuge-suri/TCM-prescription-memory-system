package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("zyyj_checkpoint")
@ApiModel(value="ZyyjCheckpointPo对象", description="")
public class ZyyjCheckpointPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关卡编号")
    @TableId(value = "checkpoint_id", type = IdType.AUTO)
    private Integer checkpointId;

    @ApiModelProperty(value = "关卡名称")
    private String name;

    @ApiModelProperty(value = "方案编号")
    private Integer programmeId;

    @ApiModelProperty(value = "限制时间（单位：分钟）")
    private Integer limitTime;

    @ApiModelProperty(value = "各种难题目数，用；隔开")
    private String questionNum;

    @ApiModelProperty(value = "总分")
    private Integer totalScore;

    @ApiModelProperty(value = "通关分数")
    private Integer passScore;

    @ApiModelProperty(value = "备注")
    private String comment;

}
