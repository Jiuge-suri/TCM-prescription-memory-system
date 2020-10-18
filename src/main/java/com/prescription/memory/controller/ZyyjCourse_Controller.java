package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCoursePo;
import com.prescription.memory.entity.vo.CourseTreeVo;
import com.prescription.memory.entity.vo.CourseVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjCourseService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.util.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/18
 */
@RestController
@Api(tags = "教师--分类管理--科目管理")
public class ZyyjCourse_Controller extends BaseController{
    @Autowired
    ZyyjCourseService courseService;

    @GetMapping("/course")
    @ApiOperation(value = "条件查询科目信息")
    public CommonreturnType ConditionQuery(@RequestParam(value = "pageNum") Integer pageNum,
                                           @RequestParam(value = "pageSize") Integer pageSize,
                                            @ApiParam(value = "科目名字")@RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(pageNum,pageSize);
        Page<CourseVo> page = courseService.getCourseByPage(name);
        PageInfo<CourseVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @GetMapping("/course/getall")
    @ApiOperation(value = "查询科目所有信息")
    public CommonreturnType getAll(){
        return CommonreturnType.create(courseService.getAll());
    }


    @GetMapping("/course/tree")
    @ApiOperation(value = "获取科目树")
    public CommonreturnType getTree(){
        List<CourseTreeVo> tree = courseService.courseTreeList();
        return CommonreturnType.create(tree);
    }
    @PostMapping("/course")
    @ApiOperation(value = "添加科目")
    public CommonreturnType addDept(@RequestBody ZyyjCoursePo coursePo){
        boolean result = courseService.insertCourse(coursePo);
        return CommonreturnType.create(result);
    }
    @DeleteMapping("/course")
    @ApiOperation(value = "删除科目")
    public CommonreturnType deleteDept(@RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result =  courseService.deleteCourse(deleteArr.getArray());
        return CommonreturnType.create(result);
    }
    @PutMapping("/course")
    @ApiOperation(value = "修改科目")
    public CommonreturnType updateDept(@RequestBody ZyyjCoursePo coursePo) throws BusinessException {
        boolean result = courseService.updateCourse(coursePo);
        return CommonreturnType.create(result);
    }
}
