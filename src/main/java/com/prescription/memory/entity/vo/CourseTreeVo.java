package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/18
 */
@Data
@ApiModel(value = "科目树")
public class CourseTreeVo implements Serializable {
    @ApiModelProperty(value = "科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "科目名称")
    private String name;

    @ApiModelProperty(value = "子集")
    private List<?> children;
}
