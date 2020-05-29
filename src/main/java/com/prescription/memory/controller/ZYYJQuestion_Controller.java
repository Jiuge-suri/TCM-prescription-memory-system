package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjQuestionPo;
import com.prescription.memory.entity.vo.QuestionVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjQuestionService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@RestController
@Api(tags = "教师--题库--题库管理")
public class ZYYJQuestion_Controller extends BaseController{
    @Autowired
    private ZyyjQuestionService questionService;

    @ApiOperation(value = "查询题库的所有数据")
    @GetMapping("/question")
    public CommonreturnType ConditionQuery(@ApiParam(value = "科目id")@RequestParam(value = "courseId",required = false) Integer courseId,
                                           @ApiParam(value = "章节id")@RequestParam(value = "chapterId",required = false) Integer chapterId,
                                           @ApiParam(value = "知识点id")@RequestParam(value = "knowId",required = false) Integer knowId,
                                           @ApiParam(value = "难度id")@RequestParam(value = "levelId",required = false) Integer levelId) {
        List<QuestionVo> list = questionService.ConditionQuery(courseId,chapterId,knowId,levelId);
        return CommonreturnType.create(list);
    }

    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/question/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getQuestionByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                              @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<QuestionVo> pageInfo = questionService.getQuestionByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新题库的数据")
    @PutMapping("/question")
    public CommonreturnType updateQuestion(@RequestBody ZyyjQuestionPo questionPo) throws BusinessException {
        boolean result = questionService.updateQuestion(questionPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除题库的数据")
    @DeleteMapping("/question")
    public CommonreturnType deleteQuestion(@ApiParam(value = "题库编号",required = true) @RequestParam(value = "questionIds") Integer[] questionIds) throws BusinessException {
        boolean result = questionService.deleteQuestion(questionIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入新的题库数据")
    @PostMapping("/question")
    public CommonreturnType insertQuestion(@RequestBody ZyyjQuestionPo questionPo) throws BusinessException {
        boolean result = questionService.insertQuestion(questionPo);
        return CommonreturnType.create(result);
    }
}
