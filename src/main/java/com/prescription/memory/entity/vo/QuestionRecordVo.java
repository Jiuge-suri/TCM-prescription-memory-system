package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="QuestionRecordVo对象", description="考题记录")
public class QuestionRecordVo implements Serializable {
    @ApiModelProperty(value = "记录编号")
    private Integer recordId;

    @ApiModelProperty(value = "题目编号")
    private Integer questionId;

    @ApiModelProperty(value = "学生选择的答案")
    private String stuChose;

    @ApiModelProperty(value = "是否做对")
    private Integer isRight;

    @ApiModelProperty(value = "类型编号")
    private Integer type;
}
