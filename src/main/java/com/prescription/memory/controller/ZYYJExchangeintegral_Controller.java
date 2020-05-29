package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.vo.ExchangeintegralVo;
import com.prescription.memory.service.ZyyjExchangeintegralService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--积分管理--积分兑换")
public class ZYYJExchangeintegral_Controller extends BaseController{
    @Autowired
    ZyyjExchangeintegralService service;

    @GetMapping("/exchange_integral")
    @ApiOperation(value = "查询所有的数据")
    public CommonreturnType getAll(){
        List<ExchangeintegralVo> all = service.getAll();
        return CommonreturnType.create(all);
    }
    @GetMapping("/exchange_integral/name/{name}/account/{account}/major/{major}/grade/{grade}/class/{class}")
    @ApiOperation(value = "条件查询")
    public CommonreturnType conditionQuery(@RequestParam(value = "name",required = false) String name,
                                           @RequestParam(value = "account",required = false) String account,
                                           @RequestParam(value = "majorId",required=false)Integer majorId,
                                           @RequestParam(value = "gradeId",required=false)Integer gradeId,
                                           @RequestParam(value = "classId",required=false)Integer classId) {
        System.out.println("测试是否进入函数");
        List<List<ExchangeintegralVo>> lists = service.conditionQuery(name, account, majorId, gradeId, classId);
        return CommonreturnType.create(lists);
    }
    @GetMapping("/exchange_integral/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                         @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ExchangeintegralVo> pageInfo = service.selectByPage(pageNum, pageSize);
        return CommonreturnType.create(pageInfo);
    }
}
