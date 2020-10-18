package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/18
 */
@Data
@ApiModel(value = "科目Model")
public class CourseVo implements Serializable {
    @ApiModelProperty(value = "科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "父节点")
    private Integer parentId;

    @ApiModelProperty(value = "上级科目编号")
    private String parentName;

    @ApiModelProperty(value = "科目名")
    private String name;

    @ApiModelProperty(value = "树节点")
    private Integer treeCode;

    @ApiModelProperty(value = "说明")
    private String introduction;

    @ApiModelProperty(value = "图片url")
    private String photo;
}
