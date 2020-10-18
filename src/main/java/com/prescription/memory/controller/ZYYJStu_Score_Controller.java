package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.vo.StuScoreVo;
import com.prescription.memory.entity.vo.StudentPracticeVo;
import com.prescription.memory.service.ZyyjStuScoreService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--积分管理--积分排行榜")
public class ZYYJStu_Score_Controller extends BaseController{
    @Autowired
    ZyyjStuScoreService service;
    @GetMapping("/stu_score")
    @ApiOperation(value = "条件查询")
    public CommonreturnType conditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @RequestParam(value = "name",required = false) String name,
                                           @RequestParam(value = "account",required = false) String account,
                                           @RequestParam(value = "majorId",required=false)Integer majorId,
                                           @RequestParam(value = "gradeId",required=false)Integer gradeId,
                                           @RequestParam(value = "classId",required=false)Integer classId,
                                           @ApiParam(value = "学院id",required = true) @RequestParam(value = "collegeId") Integer collegeId){
        Page<StuScoreVo> page = service.getStuScoreRangeByPage(pageNum,pageSize,name, account, majorId, gradeId, classId,collegeId);
        PageInfo<StuScoreVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
}
