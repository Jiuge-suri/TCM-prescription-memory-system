package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.vo.StudentPracticeVo;
import com.prescription.memory.service.ZyyjStudentPracticeService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--积分管理--学生闯关记录")
public class  ZYYJStudent_Practice_Controller extends BaseController {
    @Autowired
    ZyyjStudentPracticeService service;

    @GetMapping("/studentPractice")
    @ApiOperation(value = "条件查询")
    public CommonreturnType conditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                           @ApiParam("学生名字") @RequestParam(value = "name",required = false) String name,
                                           @ApiParam("学生学号") @RequestParam(value = "account",required = false) String account,
                                           @ApiParam("专业id")@RequestParam(value = "majorId",required=false)Integer majorId,
                                           @ApiParam("年级id") @RequestParam(value = "gradeId",required=false)Integer gradeId,
                                           @ApiParam("班级id") @RequestParam(value = "classId",required=false)Integer classId,
                                           @ApiParam(value = "学院id",required = true) @RequestParam(value = "collegeId") Integer collegeId){

        Page<StudentPracticeVo> page = service.getStudentPracticeByPage(pageNum,pageSize,name,account,majorId,gradeId,classId,collegeId);
        PageInfo<StudentPracticeVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
}
