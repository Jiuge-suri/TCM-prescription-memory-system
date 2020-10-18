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
@ApiModel(value="StudentVo", description="学生表")
public class StudentVo implements Serializable {
    @ApiModelProperty(value = "学生编号")
    private Integer stuId;

    @ApiModelProperty(value = "班级名称")
    private String className;


    @ApiModelProperty(value = "学生名称")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "是否现在的数据")
    private Integer isNow;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "学号")
    private String account;

    @ApiModelProperty(value = "头像url")
    private String photo;

    @ApiModelProperty(value = "学生状态")
    private Integer status;

    @ApiModelProperty(value = "年纪")
    private String gradeName;

    @ApiModelProperty(value = "专业")
    private String majorName;

    @ApiModelProperty(value = "学院")
    private String collegeName;

    @ApiModelProperty(value = "大学")
    private String universityName;

    @ApiModelProperty(value = "班级编号")
    private Integer classId;

    @ApiModelProperty(value = "年纪编号")
    private Integer gradeId;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "学院编号")
    private Integer collegeId;

    @ApiModelProperty(value = "大学编号")
    private Integer universityId;
}
