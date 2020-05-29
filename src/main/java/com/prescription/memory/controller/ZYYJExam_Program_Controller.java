package com.prescription.memory.controller;

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
    public CommonreturnType ConditionQuery(@ApiParam("考试方案名") @RequestParam(value = "name",required = false) String name){
        List<ExamProgramVo> all = service.ConditionQuery(name);
        return CommonreturnType.create(all);
    }
    @GetMapping("/exam_program/pageNum/{pageNum}/pageSize/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                         @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ExamProgramVo> pageInfo = service.selectByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/exam_program")
    public CommonreturnType updateExamProgram(@RequestBody ZyyjExamProgramPo examProgramPo) throws BusinessException {
        boolean result = service.updateExamProgram(examProgramPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exam_program")
    public CommonreturnType deleteExamProgram(@ApiParam(value = "编号",required = true)
                                        @RequestParam(value = "classId") Integer[] examProgramIds) throws BusinessException {
        boolean result = service.deleteExamProgram(examProgramIds);
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
