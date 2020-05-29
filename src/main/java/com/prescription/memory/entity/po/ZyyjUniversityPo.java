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
@TableName("zyyj_university")
@ApiModel(value="ZyyjUniversityPo对象", description="")
public class ZyyjUniversityPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学校编号")
    @TableId(value = "university_id", type = IdType.AUTO)
    private Integer universityId;

    @ApiModelProperty(value = "学校名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
