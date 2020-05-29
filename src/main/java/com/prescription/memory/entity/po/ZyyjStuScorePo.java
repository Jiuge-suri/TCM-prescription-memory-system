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
@TableName("zyyj_stu_score")
@ApiModel(value="ZyyjStuScorePo对象", description="")
public class ZyyjStuScorePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "积分编号")
    @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

    @ApiModelProperty(value = "学生编号")
    private Integer stuId;

    @ApiModelProperty(value = "方案编号")
    private Integer programmeId;

    @ApiModelProperty(value = "得分")
    private Integer score;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "考核类型")
    private Integer type;


}
