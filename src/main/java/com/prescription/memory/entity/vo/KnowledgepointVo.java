package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.prescription.memory.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "知识点")
public class KnowledgepointVo implements Serializable {
    @ApiModelProperty(value = "知识点编号")
    private Integer knowId;

    @ApiModelProperty(value = "要求名字")
    private String requireName;

    @ApiModelProperty(value = "所属科目名字")
    private String courseName;



    @ApiModelProperty(value = "所属章节名字")
    private String chapterName;

    @ApiModelProperty(value = "知识点名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "要求编号")
    private Integer requireId;

    @ApiModelProperty(value = "所属科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "所属章节编号")
    private Integer chapterId;

    @ApiModelProperty(value = "父节点")
    private Integer parentId;
}
