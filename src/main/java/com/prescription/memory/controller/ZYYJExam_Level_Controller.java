package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamLevelPo;
import com.prescription.memory.entity.vo.ExamLevelVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjExamLevelService;
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
@Api(tags = "学院秘书--考试管理--考试等级管理")
public class ZYYJExam_Level_Controller extends BaseController {
    @Autowired
    ZyyjExamLevelService service;

    @GetMapping("/exam_level")
    @ApiOperation(value = "条件查询考试等级数据")
    public CommonreturnType ConditionQuery(@ApiParam("考试等级名") @RequestParam(value = "name",required = false) String name){
        List<ExamLevelVo> all = service.ConditionQuery(name);
        return CommonreturnType.create(all);
    }
    @GetMapping("/exam_level/pageNum/{pageNum}/pageSize/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                         @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ExamLevelVo> pageInfo = service.selectByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/exam_level")
    public CommonreturnType updateExamLevel(@RequestBody ZyyjExamLevelPo examLevelPo) throws BusinessException {
        boolean result = service.updateExamLevel(examLevelPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exam_level")
    public CommonreturnType deleteExamLevel(@ApiParam(value = "编号",required = true)
                                            @RequestParam(value = "classId") Integer[] examLevelIds) throws BusinessException {
        boolean result = service.deleteExamLevel(examLevelIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/exam_level")
    public CommonreturnType insertExamLevel(@RequestBody ZyyjExamLevelPo examLevelPo) throws BusinessException {
        boolean result = service.insertExamLevel(examLevelPo);
        return CommonreturnType.create(result);
    }
}
