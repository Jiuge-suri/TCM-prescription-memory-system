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
@TableName("zyyj_question_type")
@ApiModel(value="ZyyjQuestionTypePo对象", description="")
public class ZyyjQuestionTypePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "问题类型编号")
    @TableId(value = "question_type_id", type = IdType.AUTO)
    private Integer questionTypeId;

    @ApiModelProperty(value = "问题类型名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
