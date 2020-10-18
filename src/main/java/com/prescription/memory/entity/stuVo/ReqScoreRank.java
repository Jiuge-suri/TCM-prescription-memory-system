package com.prescription.memory.entity.stuVo;

import com.prescription.memory.entity.vo.StuScoreVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "积分排行榜")
public class ReqScoreRank implements Serializable {
    @ApiModelProperty(value = "当前用户排名")
    private Integer myrank;
    @ApiModelProperty(value = "当前用户积分")
    private Integer myscore;
    @ApiModelProperty(value = "当前用户姓名")
    private String myname;
    @ApiModelProperty(value = "学号")
    private String account;
    @ApiModelProperty(value = "为数据数组，前30名的积分情况")
    private List<RankInfo> ranklist;
}
