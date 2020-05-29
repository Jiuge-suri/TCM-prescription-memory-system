package com.prescription.memory.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="CollegeVo", description="学院多表联查结果集映射对象")
public class CollegeVo implements Serializable {

    @ApiModelProperty(value = "学院编号")
    private Integer collegeId;
    @ApiModelProperty(value = "所属大学名")
    private String universityName;
    @ApiModelProperty(value = "学院名")
    private String name;
    @ApiModelProperty(value = "备注")
    private String comment;
}
