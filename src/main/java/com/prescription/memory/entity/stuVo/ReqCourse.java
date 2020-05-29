package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "返回的科目信息")
public class ReqCourse implements Serializable {

    @ApiModelProperty(value = "科目id")
    private Integer courseId;
    @ApiModelProperty(value = "科目名称")
    private String name;
    @ApiModelProperty(value = "科目介绍")
    private String introduction;
    @ApiModelProperty(value = "科目图片地址")
    private String photo;
}
