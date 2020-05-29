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
@TableName("zyyj_question")
@ApiModel(value="ZyyjQuestionPo对象", description="")
public class ZyyjQuestionPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色编号")
    @TableId(value = "question_id", type = IdType.AUTO)
    private Integer questionId;

    @ApiModelProperty(value = "角色名称")
    private Integer levelId;

    @ApiModelProperty(value = "知识点编号")
    private Integer knowId;

    @ApiModelProperty(value = "备注")
    private Integer questionTypeId;

    @ApiModelProperty(value = "问题")
    private String question;

    @ApiModelProperty(value = "答案1")
    private String answer1;

    @ApiModelProperty(value = "答案2")
    private String answer2;

    @ApiModelProperty(value = "答案3")
    private String answer3;

    @ApiModelProperty(value = "答案4")
    private String answer4;

    @ApiModelProperty(value = "正确答案")
    private String rightanswer;

    @ApiModelProperty(value = "问题照片url")
    private String photo;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "科目编号")
    private Integer courseId;

    @ApiModelProperty(value = "章节编号")
    private Integer chapterId;


}
