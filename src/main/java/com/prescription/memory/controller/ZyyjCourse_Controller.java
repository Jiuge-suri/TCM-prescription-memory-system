package com.prescription.memory.controller;

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
    public CommonreturnType ConditionQuery(@ApiParam(value = "科目名字")@RequestParam(value = "name",required = false) String name){
        List<CourseVo> list = courseService.ConditionQuery(name);
        return CommonreturnType.create(list);
    }
    @GetMapping("/course/pageNum/{pageNum}/pageSize/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@PathVariable(value = "pageNum") Integer pageNum,
                                         @PathVariable(value = "pageSize") Integer pageSize){
        PageInfo<CourseVo> pageInfo = courseService.getCourseByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
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
    public CommonreturnType deleteDept(@RequestParam Integer[] courseIds) throws BusinessException {
        boolean result =  courseService.deleteCourse(courseIds);
        return CommonreturnType.create(result);
    }
    @PutMapping("/course")
    @ApiOperation(value = "修改科目")
    public CommonreturnType updateDept(@RequestBody ZyyjCoursePo coursePo) throws BusinessException {
        boolean result = courseService.updateCourse(coursePo);
        return CommonreturnType.create(result);
    }
}
