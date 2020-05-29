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
@TableName("zyyj_knowledgepoint")
@ApiModel(value="ZyyjKnowledgepointPo对象", description="")
public class ZyyjKnowledgepointPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "知识点编号")
    @TableId(value = "know_id", type = IdType.AUTO)
    private Integer knowId;

    @ApiModelProperty(value = "要求编号")
    private Integer requireId;

    @ApiModelProperty(value = "所属科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "所属章节编号")
    private Integer chapterId;

    @ApiModelProperty(value = "知识点名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;


}
