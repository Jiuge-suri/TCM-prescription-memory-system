package com.prescription.memory.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yinjie on 2020/5/12
 */
@Data
@ApiModel(value="ProgrammeVo对象", description="练习方案")
public class ProgrammeVo implements Serializable {
    @ApiModelProperty(value = "方案编号")
    private Integer programmeId;

    @ApiModelProperty(value = "方案名")
    private String name;

    @ApiModelProperty(value = "创建日期")
    private Date createdate;

    @ApiModelProperty(value = "总积分")
    private Integer score;

    @ApiModelProperty(value = "备注")
    private String comment;
}
