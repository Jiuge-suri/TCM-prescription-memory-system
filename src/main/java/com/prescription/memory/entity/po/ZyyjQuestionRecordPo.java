package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.Api;
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
@TableName("zyyj_question_record")
@ApiModel(value="ZyyjQuestionRecordPo对象", description="")
public class ZyyjQuestionRecordPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录编号")
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    @ApiModelProperty(value = "题目编号")
    private Integer questionId;

    @ApiModelProperty(value = "学生选择的答案")
    private String stuChose;

    @ApiModelProperty(value = "是否做对")
    private Integer isRight;

    @ApiModelProperty(value = "类型编号")
    private Integer type;

    @ApiModelProperty(value = "学生编号")
    private Integer stuId;

    @ApiModelProperty(value = "科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "关卡编号")
    private Integer checkpointId;

}
