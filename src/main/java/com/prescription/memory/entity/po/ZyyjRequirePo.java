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
@TableName("zyyj_require")
@ApiModel(value="ZyyjRequirePo对象", description="")
public class ZyyjRequirePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "要求编号")
    @TableId(value = "require_id", type = IdType.AUTO)
    private Integer requireId;

    @ApiModelProperty(value = "要求名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
