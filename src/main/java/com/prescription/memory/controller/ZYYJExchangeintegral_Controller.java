package com.prescription.memory.controller;

import com.github.pagehelper.Page;
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
    @ApiOperation(value = "条件查询")
    public CommonreturnType conditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @RequestParam(value = "name",required = false) String name,
                                           @RequestParam(value = "account",required = false) String account,
                                           @RequestParam(value = "majorId",required=false)Integer majorId,
                                           @RequestParam(value = "gradeId",required=false)Integer gradeId,
                                           @RequestParam(value = "classId",required=false)Integer classId,
                                           @ApiParam(value = "学院id",required = true) @RequestParam(value = "collegeId") Integer collegeId) {
        Page<ExchangeintegralVo> page = service.getIntegralByPage(pageNum,pageSize,name, account, majorId, gradeId, classId,collegeId);
        PageInfo<ExchangeintegralVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
}
