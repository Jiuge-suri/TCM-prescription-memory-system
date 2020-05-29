package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "题库表")
public class QuestionVo implements Serializable {
    @ApiModelProperty(value = "题目编号")
    private Integer questionId;

    @ApiModelProperty(value = "等级名称")
    private String levelName;

    @ApiModelProperty(value = "知识点名称")
    private String knowName;

    @ApiModelProperty(value = "问题类型")
    private String questionTypeName;

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

    @ApiModelProperty(value = "问题照片url")
    private String photo;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "科目名称")
    private String courseName;

    @ApiModelProperty(value = "章节名称")
    private String chapterName;
}
