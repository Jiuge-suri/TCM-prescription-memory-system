package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum",required = true) Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize",required = true)Integer pageSize,
                                            @ApiParam(value = "学院id",required = true) @RequestParam(value = "collegeId",required = true) Integer collegeId,
                                           @ApiParam(value = "专业id",required = false) @RequestParam(value = "majorId",required = false) Integer majorId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<MajorVo> page = majorService.getMajorByPage(collegeId, majorId);
        PageInfo<MajorVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查寻专业所有数据")
    @GetMapping("/major/getall")
    public CommonreturnType getAll(@ApiParam("学院id") @RequestParam(value = "collegeId",required = false) Integer collegeId){
        List<ZyyjMajorPo> all = majorService.getAll(collegeId);
        return CommonreturnType.create(all);
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
                                            @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = majorService.deleteMajor(deleteArr.getArray());
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
