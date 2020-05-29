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
@TableName("zyyj_exam_type")
@ApiModel(value="ZyyjExamTypePo对象", description="")
public class ZyyjExamTypePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考试类型编号")
    @TableId(value = "exam_type_id", type = IdType.AUTO)
    private Integer examTypeId;

    @ApiModelProperty(value = "考试类型名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
