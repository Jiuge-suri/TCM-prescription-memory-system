package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("规则名") @RequestParam(value = "name",required = false) String name) {
        PageHelper.startPage(pageNum,pageSize);
        Page<ZyyjExchangerulePo> page = exchangeruleService.getExchangeruleByPage(name);
        PageInfo<ZyyjExchangerulePo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查询积分兑换规则所有的数据")
    @GetMapping("/exchangerule/getall")
    public CommonreturnType getAll(){
        return CommonreturnType.create(exchangeruleService.getAll());
    }


    @ApiOperation(value = "更新数据")
    @PutMapping("/exchangerule")
    public CommonreturnType updateExchangerule(@RequestBody ZyyjExchangerulePo exchangerulePo) throws BusinessException {
        boolean result = exchangeruleService.updateExchangerule(exchangerulePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exchangerule")
    public CommonreturnType deleteExchangerule(@ApiParam(value = "编号")
                                                   @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = exchangeruleService.deleteExchangerule(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/exchangerule")
    public CommonreturnType insertExchangerule(@RequestBody ZyyjExchangerulePo exchangerulePo){
        boolean result = exchangeruleService.insertExchangerule(exchangerulePo);
        return CommonreturnType.create(result);
    }
}
