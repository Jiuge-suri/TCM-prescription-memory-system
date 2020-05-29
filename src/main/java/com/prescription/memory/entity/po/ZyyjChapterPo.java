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
@TableName("zyyj_chapter")
@ApiModel(value="ZyyjChapterPo对象", description="")
public class ZyyjChapterPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "章节编号")
    @TableId(value = "chapter_id", type = IdType.AUTO)
    private Integer chapterId;

    @ApiModelProperty(value = "章节姓名")
    private String name;

    @ApiModelProperty(value = "课程编号")
    private Integer courseId;

    @ApiModelProperty(value = "图片")
    private String photo;

    @ApiModelProperty(value = "备注")
    private String comment;


}
