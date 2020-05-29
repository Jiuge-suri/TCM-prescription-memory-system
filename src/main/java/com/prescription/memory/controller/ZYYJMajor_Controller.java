package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjMajorPo;
import com.prescription.memory.entity.vo.MajorVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjMajorService;
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
@Api(tags = "学院秘书--学生管理--专业管理")
public class ZYYJMajor_Controller extends BaseController{
    @Autowired
    private ZyyjMajorService majorService;

    @ApiOperation(value = "条件查寻专业数据")
    @GetMapping("/major")
    public CommonreturnType ConditionQuery(@ApiParam(value = "学院id") @RequestParam(value = "collegeId",required = false) Integer collegeId) {
        List<MajorVo> list = majorService.ConditionQuery(collegeId);
        return CommonreturnType.create(list);
    }

    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/major/{pageNum}/{pageSize}")
    public CommonreturnType getMajorByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<MajorVo> pageInfo = majorService.getMajorByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/major")
    public CommonreturnType updateMajor(@RequestBody ZyyjMajorPo majorPo) throws BusinessException {
        boolean result = majorService.updateMajor(majorPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/major")
    public CommonreturnType deleteMajor(@ApiParam(value = "编号")
                                            @RequestParam(value = "majorId") Integer[] majorIds) throws BusinessException {
        boolean result = majorService.deleteMajor(majorIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/major")
    public CommonreturnType insertMajor(@RequestBody ZyyjMajorPo majorPo){
        //将Vo转换成Po
        boolean result = majorService.insertMajor(majorPo);
        return CommonreturnType.create(result);
    }
}
