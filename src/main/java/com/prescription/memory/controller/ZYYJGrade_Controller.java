package com.prescription.memory.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjGradePo;
import com.prescription.memory.entity.vo.GradeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjGradeService;
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
@Api(tags = "学院秘书--学生管理--年级管理",value = "年级相关接口")
public class ZYYJGrade_Controller extends BaseController {
    @Autowired
    private ZyyjGradeService gradeService;

    @ApiOperation(value = "多条件查询年级数据")
    @GetMapping("/grade")
    public CommonreturnType ConditionQuery(@ApiParam(value = "专业id") @RequestParam(value = "majorId",required = false) Integer majorId) {
        List<GradeVo> list = gradeService.ConditionQuery(majorId);
        return CommonreturnType.create(list);
    }
    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/grade/{pageNum}/{pageSize}")
    public CommonreturnType getGradeByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<GradeVo> pageInfo = gradeService.getGradeByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/grade")
    public CommonreturnType updateGrade(@RequestBody ZyyjGradePo gradePo) throws BusinessException {
        boolean result = gradeService.updateGrade(gradePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/grade")
    public CommonreturnType deleteGrade(@ApiParam(value = "编号",required = true)
                                        @RequestParam(value = "gradeId") Integer[] gradeIds) throws BusinessException {
        boolean result = gradeService.deleteGrade(gradeIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/grade")
    public CommonreturnType insertGrade(@RequestBody ZyyjGradePo gradePo){
        //将Vo转换成Po
        boolean result = gradeService.insertGrade(gradePo);
        return CommonreturnType.create(result);
    }
}
