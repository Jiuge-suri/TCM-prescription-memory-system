package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjClassPo;
import com.prescription.memory.entity.vo.ClassVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjClassService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "学院秘书--学生管理--班级管理",value = "班级模块相关接口")
public class ZYYJClass_Controller extends BaseController{
    @Autowired
    private ZyyjClassService classService;

    @ApiOperation(value = "多条件查询班级数据")
    @GetMapping("/class")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
            @ApiParam(value = "年级id") @RequestParam(value = "gradeId",required = false) Integer gradeId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<ClassVo> page = classService.getClassByPage(gradeId);
        PageInfo<ClassVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查询班级所有的数据")
    @GetMapping("/class/getall")
    public CommonreturnType getAll(@ApiParam(value = "年级id") @RequestParam(value = "gradeId",required = false) Integer gradeId){
        return CommonreturnType.create(classService.getAll(gradeId));
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("/class")
    public CommonreturnType updateClass(@RequestBody ZyyjClassPo classPo) throws BusinessException {
        boolean result = classService.updateClass(classPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/class")
    public CommonreturnType deleteClass(@ApiParam(value = "编号")
                                            @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = classService.deleteClass(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/class")
    public CommonreturnType insertClass(@RequestBody ZyyjClassPo classPo){
        boolean result = classService.insertClass(classPo);
        return CommonreturnType.create(result);
    }
}
