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
@TableName("zyyj_course")
@ApiModel(value="ZyyjCoursePo对象", description="")
public class ZyyjCoursePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科目编号")
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    @ApiModelProperty(value = "上级科目编号")
    private Integer parentId;

    @ApiModelProperty(value = "科目名")
    private String name;

    @ApiModelProperty(value = "树节点")
    private Integer treeCode;

    @ApiModelProperty(value = "说明")
    private String introduction;

    @ApiModelProperty(value = "如片url")
    private String photo;

    public Integer getParentId(){
        return parentId;
    }
}
