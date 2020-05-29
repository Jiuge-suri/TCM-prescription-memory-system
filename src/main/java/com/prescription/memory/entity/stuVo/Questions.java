package com.prescription.memory.entity.stuVo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/22
 */
@Data
@ApiModel(value = "获得的题目表")
public class Questions implements Serializable {
    @ApiModelProperty(value = "角色编号")
    private Integer questionId;

    @ApiModelProperty(value = "问题")
    private String question;

    @ApiModelProperty(value = "答案1")
    private String answer1;

    @ApiModelProperty(value = "答案2")
    private String answer2;

    @ApiModelProperty(value = "答案3")
    private String answer3;

    @ApiModelProperty(value = "答案4")
    private String answer4;

    @ApiModelProperty(value = "正确答案")
    private String rightanswer;
}
