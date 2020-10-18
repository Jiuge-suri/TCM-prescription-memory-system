package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("考试等级名") @RequestParam(value = "name",required = false) String name){

        Page<ExamLevelVo> page = service.getExamLevelByPage(pageNum,pageSize,name);
        PageInfo<ExamLevelVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @GetMapping("/exam_level/getall")
    @ApiOperation(value = "查询考试等级所有数据")
    public CommonreturnType getAll(){
        return CommonreturnType.create(service.getAll());
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("/exam_level")
    public CommonreturnType updateExamLevel(@RequestBody ZyyjExamLevelPo examLevelPo) throws BusinessException {
        boolean result = service.updateExamLevel(examLevelPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/exam_level")
    public CommonreturnType deleteExamLevel(@ApiParam(value = "编号")
                                                @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = service.deleteExamLevel(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/exam_level")
    public CommonreturnType insertExamLevel(@RequestBody ZyyjExamLevelPo examLevelPo) throws BusinessException {
        boolean result = service.insertExamLevel(examLevelPo);
        return CommonreturnType.create(result);
    }
}
