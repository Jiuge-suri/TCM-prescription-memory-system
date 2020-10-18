package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.vo.StudentVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjStudentService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--学生管理--学生信息管理", value = "学生相关接口")
public class ZYYJStudent_Controller extends BaseController{
    @Autowired
    private ZyyjStudentService studentService;

    @ApiOperation(value = "多条件查询")
    @GetMapping("/student")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum",required = true) Integer pageNum,
                                      @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize",required = true)Integer pageSize,
                                           @ApiParam("专业id") @RequestParam(value = "majorId",required = false) Integer majorId,
                                      @ApiParam("年级id") @RequestParam(value = "gradeId",required = false) Integer gradeId,
                                      @ApiParam("班级id") @RequestParam(value = "classId",required = false)Integer classId,
                                      @ApiParam("性别") @RequestParam(value = "sex",required = false)Integer sex,
                                      @ApiParam("学号") @RequestParam(value = "account",required = false)String account,
                                      @ApiParam("姓名") @RequestParam(value = "name",required = false)String name,
                                      @ApiParam(value = "学院id",required = true) @RequestParam(value = "collegeId",required = true)Integer collegeId){
        PageHelper.startPage(pageNum,pageSize);
        Page<StudentVo> page = studentService.getStudentByPage(majorId, gradeId, classId, sex, account, name, collegeId);
        PageInfo<StudentVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("/student")
    public CommonreturnType updateStudent(@RequestBody ZyyjStudentPo studentPo) throws BusinessException {
        boolean result = studentService.updateStudent(studentPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/student")
    public CommonreturnType deleteStudent(@ApiParam(value = "编号")
                                              @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = studentService.deleteStudent(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/student")
    public CommonreturnType insertStudent(@RequestBody ZyyjStudentPo studentPo){
        boolean result = studentService.insertStudent(studentPo);
        return CommonreturnType.create(result);
    }


}
