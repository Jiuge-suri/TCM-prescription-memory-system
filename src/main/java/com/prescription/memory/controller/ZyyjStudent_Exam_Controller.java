package com.prescription.memory.controller;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.vo.StudentExamVo;
import com.prescription.memory.entity.vo.StudentVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjStudentExamService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/26
 */
@RestController
@Api(tags = "学院秘书--考试管理--考试记录管理")
public class ZyyjStudent_Exam_Controller extends BaseController {
    @Autowired
    private ZyyjStudentExamService studentExamService;
    @ApiOperation(value = "多条件查询")
    @GetMapping("/student_exam")
    public CommonreturnType ConditionQuery(@ApiParam(value = "学号")@RequestParam(value = "account",required = false) String account,
                                           @ApiParam(value = "姓名")@RequestParam(value = "name",required = false)String name,
                                           @ApiParam(value = "专业")@RequestParam(value = "majorId",required = false)Integer majorId,
                                           @ApiParam(value = "年级")@RequestParam(value = "gradeId",required = false)Integer gradeId,
                                           @ApiParam(value = "班级")@RequestParam(value = "classId",required = false)Integer classId,
                                           @ApiParam(value = "科目")@RequestParam(value = "courseId",required = false)Integer courseId){
        List<StudentExamVo> lists = studentExamService.ConditionQuery(account, name, majorId, gradeId, classId, courseId);
        return CommonreturnType.create(lists);
    }
    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/studentExam/{pageNum}/{pageSize}")
    public CommonreturnType getExamRecordByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                             @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize) throws BusinessException {
        PageInfo<StudentExamVo> pageInfo = studentExamService.getExamRecordByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
}
