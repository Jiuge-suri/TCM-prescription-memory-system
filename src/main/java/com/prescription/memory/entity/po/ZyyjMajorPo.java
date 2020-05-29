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
@TableName("zyyj_major")
@ApiModel(value="ZyyjMajorPo对象", description="")
public class ZyyjMajorPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专业编号")
    @TableId(value = "major_id", type = IdType.AUTO)
    private Integer majorId;

    @ApiModelProperty(value = "学院编号")
    private Integer collegeId;

    @ApiModelProperty(value = "专业名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
