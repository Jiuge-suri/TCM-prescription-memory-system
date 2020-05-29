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
@TableName("zyyj_student")
@ApiModel(value="ZyyjStudentPo对象", description="")
public class ZyyjStudentPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生编号")
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;

    @ApiModelProperty(value = "班级编号")
    private Integer classId;

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

    @ApiModelProperty(value = "年纪编号")
    private Integer gradeId;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "学院编号")
    private Integer collegeId;

    @ApiModelProperty(value = "大学编号")
    private Integer universityId;


}
