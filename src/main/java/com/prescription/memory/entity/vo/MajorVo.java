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
@ApiModel(value="MajorVo对象", description="专业")
public class MajorVo implements Serializable {
    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "学院名称")
    private String collegeName;

    @ApiModelProperty(value = "专业名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;
}
