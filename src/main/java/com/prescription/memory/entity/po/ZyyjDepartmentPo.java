package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("zyyj_department")
@ApiModel(value="ZyyjDepartmentPo对象", description="")
public class ZyyjDepartmentPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门编号")
    @TableId(value = "department_id", type = IdType.AUTO)
    private Integer departmentId;

    @ApiModelProperty(value = "学院编号")
    private Integer collegeId;

    @ApiModelProperty(value = "上级部门编号")
    private Integer parentId;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "树节点（在数的第几级）")
    private Integer treeCode;

}
