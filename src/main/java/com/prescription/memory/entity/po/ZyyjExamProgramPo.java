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
@TableName("zyyj_exam_program")
@ApiModel(value="ZyyjExamProgramPo对象", description="")
public class ZyyjExamProgramPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考试方案编号")
    @TableId(value = "program_id", type = IdType.AUTO)
    private Integer programId;

    @ApiModelProperty(value = "考试方案名")
    private String name;

    @ApiModelProperty(value = "等级数")
    private Integer levelNum;

    @ApiModelProperty(value = "方案创建日期")
    private Date createdate;


}
