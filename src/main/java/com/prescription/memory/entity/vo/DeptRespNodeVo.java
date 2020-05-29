package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/16
 */
@Data
@ApiModel("部门树")
public class DeptRespNodeVo implements Serializable {
    @ApiModelProperty(value = "部门编号")
    private Integer departmentId;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "子集")
    private List<?> children;
}
