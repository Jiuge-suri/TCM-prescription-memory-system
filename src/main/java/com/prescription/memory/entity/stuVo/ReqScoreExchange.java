package com.prescription.memory.entity.stuVo;

import com.prescription.memory.entity.po.ZyyjExchangeintegralPo;
import com.prescription.memory.entity.po.ZyyjExchangerulePo;
import com.prescription.memory.entity.vo.ExchangeintegralVo;
import com.prescription.memory.entity.vo.ExchangeruleVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Data
@ApiModel(value = "积分界面反馈信息")
public class ReqScoreExchange implements Serializable {
    @ApiModelProperty(value = "当status为0时存在，为兑换记录的数据集")
    private ExchangeintegralInfo cglist;
    @ApiModelProperty(value = "个人积分")
    private Integer myscore;
    @ApiModelProperty(value = "为当前兑换规则的信息数组")
    private List<ExchangeruleInfo> rules;
}
