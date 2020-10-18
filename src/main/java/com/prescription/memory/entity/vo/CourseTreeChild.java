package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.naming.directory.SearchResult;
import java.io.Serializable;

/**
 * Created by Yinjie on 2020/6/4
 */
@Data
@ApiModel("子科目树")
public class CourseTreeChild implements Serializable {
    @ApiModelProperty(value = "科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "科目名称")
    private String name;
}
