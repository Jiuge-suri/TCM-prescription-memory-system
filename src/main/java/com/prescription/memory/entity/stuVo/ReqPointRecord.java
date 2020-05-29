package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/21
 */
@Data
@ApiModel(value = "学生闯关记录表")
public class ReqPointRecord implements Serializable {
    @ApiModelProperty(value = "练习id")
    private Integer practiceId;
    @ApiModelProperty(value = "科目名称")
    private String coursename;
    @ApiModelProperty(value = "当前关卡名称")
    private String pointname;
}
