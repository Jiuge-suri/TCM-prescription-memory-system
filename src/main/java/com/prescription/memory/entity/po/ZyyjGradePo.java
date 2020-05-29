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
@TableName("zyyj_grade")
@ApiModel(value="ZyyjGradePo对象", description="")
public class ZyyjGradePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "年级编号")
    @TableId(value = "grade_id", type = IdType.AUTO)
    private Integer gradeId;

    @ApiModelProperty(value = "专业编号")
    private Integer majorId;

    @ApiModelProperty(value = "年级名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
