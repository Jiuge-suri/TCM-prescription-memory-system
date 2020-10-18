package com.prescription.memory.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjGradePo;
import com.prescription.memory.entity.vo.GradeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjGradeService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "学院秘书--学生管理--年级管理",value = "年级相关接口")
public class ZYYJGrade_Controller extends BaseController {
    @Autowired
    private ZyyjGradeService gradeService;

    @ApiOperation(value = "多条件查询年级数据")
    @GetMapping("/grade")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                           @ApiParam(value = "专业Id",required = false) @RequestParam(value = "majorname",required = false) Integer majorId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<GradeVo> page = gradeService.getGradeByPage(majorId);
        PageInfo<GradeVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查询年级所有的数据")
    @GetMapping("/grade/getall")
    public CommonreturnType getAll(@ApiParam(value = "专业id") @RequestParam(value = "majorId",required = false) Integer majorId){
        System.out.println(majorId);
        List<ZyyjGradePo> all = gradeService.getAll(majorId);
        return CommonreturnType.create(all);
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
                                            @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = gradeService.deleteGrade(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/grade")
    public CommonreturnType insertGrade(@RequestBody ZyyjGradePo gradePo){
        boolean result = gradeService.insertGrade(gradePo);
        return CommonreturnType.create(result);
    }
}
