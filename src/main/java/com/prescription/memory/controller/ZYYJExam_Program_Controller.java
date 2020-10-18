package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamProgramPo;
import com.prescription.memory.entity.vo.ExamProgramVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjExamProgramService;
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
@Api(tags = "学院秘书--考试管理--考试方案管理")
public class ZYYJExam_Program_Controller extends BaseController{
    @Autowired
    ZyyjExamProgramService service;

    @GetMapping("/exam_program")
    @ApiOperation(value = "条件查询考试方案数据")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("考试方案名") @RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(pageNum,pageSize);
        Page<ExamProgramVo> page = service.getExamProgrammeByPage(name);
        PageInfo<ExamProgramVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @GetMapping("/exam_program/getall")
    @ApiOperation(value = "查询考试方案所有的数据")
    public CommonreturnType getAll(){
        return CommonreturnType.create(service.getAll());
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("/exam_program")
    public CommonreturnType updateExamProgram(@RequestBody ZyyjExamProgramPo examProgramPo) throws BusinessException {
        boolean result = service.updateExamProgram(examProgramPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exam_program")
    public CommonreturnType deleteExamProgram(@ApiParam(value = "编号")
                                                  @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = service.deleteExamProgram(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/exam_program")
    public CommonreturnType insertExamProgram(@RequestBody ZyyjExamProgramPo examProgramPo){
        //将Vo转换成Po
        boolean result = service.insertExamProgram(examProgramPo);
        return CommonreturnType.create(result);
    }
}
