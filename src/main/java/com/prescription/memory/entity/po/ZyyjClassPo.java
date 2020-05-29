package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("zyyj_class")
@ApiModel(value="ZyyjClassPo对象", description="")
public class ZyyjClassPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级编号")
    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    @ApiModelProperty(value = "年纪编号")
    private Integer gradeId;

    @ApiModelProperty(value = "部门编号")
    private Integer departmentId;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;


}
