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
@TableName("zyyj_exam_level")
@ApiModel(value="ZyyjExamLevelPo对象", description="")
public class ZyyjExamLevelPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考试等级编号")
    @TableId(value = "level_id", type = IdType.AUTO)
    private Integer levelId;

    @ApiModelProperty(value = "所属考试方案编号")
    private Integer programId;

    @ApiModelProperty(value = "考试等级名")
    private String name;

    @ApiModelProperty(value = "总题目数")
    private Integer totalQuestion;

    @ApiModelProperty(value = "总分数")
    private Integer totalScore;

    @ApiModelProperty(value = "通过分数")
    private Integer passScore;

    @ApiModelProperty(value = "各种难度题目，用；隔开")
    private String questionNum;

    @ApiModelProperty(value = "答题时长")
    private Integer limitTime;


}
