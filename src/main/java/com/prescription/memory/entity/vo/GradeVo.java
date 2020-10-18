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
@ApiModel(value="GradeVo对象", description="年级")
public class GradeVo implements Serializable {
    @ApiModelProperty(value = "年级编号")
    private Integer gradeId;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "专业名称")
    private String majorName;

    @ApiModelProperty(value = "年级名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;
}
