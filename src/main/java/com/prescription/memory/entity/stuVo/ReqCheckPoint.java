package com.prescription.memory.entity.stuVo;

import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "返回关卡信息")
public class ReqCheckPoint implements Serializable {
    @ApiModelProperty(value = "目前学生所达到的关卡id")
    private Integer havePassedId;
    @ApiModelProperty(value = "返回所有关卡信息")
    private List<ZyyjCheckpointPo> totalCheckpoint;

}
