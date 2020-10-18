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
@ApiModel(value="ClassVo", description="班级")
public class ClassVo implements Serializable {
    @ApiModelProperty(value = "班级编号")
    private Integer classId;

    @ApiModelProperty(value = "年纪名称")
    private String gradeName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "专业名字")
    private String majorName;

    @ApiModelProperty(value = "年纪编号")
    private Integer gradeId;

    @ApiModelProperty(value = "部门编号")
    private Integer departmentId;

}
