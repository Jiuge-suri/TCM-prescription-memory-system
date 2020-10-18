package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@TableName("zyyj_student_practice")
@ApiModel(value="ZyyjStudentPracticePo对象", description="")
public class ZyyjStudentPracticePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录编号")
    @TableId(value = "practice_id", type = IdType.AUTO)
    private Integer practiceId;

    @ApiModelProperty(value = "学生编号")
    private Integer stuId;

    @ApiModelProperty(value = "关卡（考试等级）编号")
    private Integer checkpointId;

    @ApiModelProperty(value = "是否通关")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "分数")
    private Integer score;

    @ApiModelProperty(value = "考试类型")
    private Integer type;

    @ApiModelProperty(value = "方案编号")
    private Integer programmeId;

    @ApiModelProperty(value = "科目编号")
    private Integer courseId;


}
