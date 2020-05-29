package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/18
 */
@Data
@ApiModel(value="ChapterVo", description="章节关卡")
public class ChapterVo implements Serializable {
    @ApiModelProperty(value = "章节编号")
    private Integer chapterId;

    @ApiModelProperty(value = "章节姓名")
    private String name;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "图片")
    private String photo;

    @ApiModelProperty(value = "备注")
    private String comment;
}
