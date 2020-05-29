package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExchangerulePo;
import com.prescription.memory.entity.vo.ExchangeruleVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjExchangeruleService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--积分管理--积分兑换规则管理")
public class ZYYJExchangerule_Controller extends BaseController{
    @Autowired
    private ZyyjExchangeruleService exchangeruleService;

    @ApiOperation(value = "条件查询积分兑换规则数据")
    @GetMapping("/exchangerule")
    public CommonreturnType ConditionQuery(@ApiParam("规则名") @RequestParam(value = "name",required = false) String name) {
        List<ExchangeruleVo> list = exchangeruleService.ConditionQuery(name);
        return CommonreturnType.create(list);
    }

    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/exchangerule/{pageNum}/{pageSize}")
    public CommonreturnType getExchangeruleByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                                  @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ExchangeruleVo> pageInfo = exchangeruleService.getExchangeruleByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/exchangerule")
    public CommonreturnType updateExchangerule(@RequestBody ZyyjExchangerulePo exchangerulePo) throws BusinessException {
        boolean result = exchangeruleService.updateExchangerule(exchangerulePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exchangerule")
    public CommonreturnType deleteExchangerule(@ApiParam(value = "编号",required = true)
                                               @RequestParam(value = "exchangeruleId") Integer[] ruleIds) throws BusinessException {
        boolean result = exchangeruleService.deleteExchangerule(ruleIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/exchangerule")
    public CommonreturnType insertExchangerule(@RequestBody ZyyjExchangerulePo exchangerulePo){
        boolean result = exchangeruleService.insertExchangerule(exchangerulePo);
        return CommonreturnType.create(result);
    }
}
