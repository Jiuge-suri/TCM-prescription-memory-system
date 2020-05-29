package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="DepartmentVo对象", description="部门")
public class DepartmentVo implements Serializable {
    @ApiModelProperty(value = "部门编号")
    private Integer departmentId;

    @ApiModelProperty(value = "学院名称")
    private String collegeName;

    @ApiModelProperty(value = "上级部门名称")
    private String parentName;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "树节点（在数的第几级）")
    private Integer treeCode;

}
