package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjClassPo;
import com.prescription.memory.entity.vo.ClassVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjClassService;
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
@Api(tags = "学院秘书--学生管理--班级管理",value = "班级模块相关接口")
public class ZYYJClass_Controller extends BaseController{
    @Autowired
    private ZyyjClassService classService;

    @ApiOperation(value = "多条件查询班级数据")
    @GetMapping("/class")
    public CommonreturnType ConditionQuery(@ApiParam(value = "年级id") @RequestParam(value = "gradeId",required = false) Integer gradeId,
                                           @ApiParam(value = "专业id") @RequestParam(value = "majorId",required = false)Integer majorId) {
        List<ClassVo> list = classService.ConditionQuery(gradeId, majorId);
        return CommonreturnType.create(list);
    }

    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/class/{pageNum}/{pageSize}")
    public CommonreturnType getClassByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ClassVo> pageInfo = classService.getClassByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/class")
    public CommonreturnType updateClass(@RequestBody ZyyjClassPo classPo) throws BusinessException {
        boolean result = classService.updateClass(classPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/class")
    public CommonreturnType deleteClass(@ApiParam(value = "编号",required = true)
                                        @RequestParam(value = "classId") Integer[] classIds) throws BusinessException {
        boolean result = classService.deleteClass(classIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/class")
    public CommonreturnType insertClass(@RequestBody ZyyjClassPo classPo){
        boolean result = classService.insertClass(classPo);
        return CommonreturnType.create(result);
    }
}
