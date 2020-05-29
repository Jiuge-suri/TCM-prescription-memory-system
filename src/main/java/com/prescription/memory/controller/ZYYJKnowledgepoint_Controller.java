package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjKnowledgepointPo;
import com.prescription.memory.entity.vo.KnowledgepointVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjKnowledgepointService;
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
@Api(tags = "教师--分类管理--知识点管理")
public class ZYYJKnowledgepoint_Controller extends BaseController{
    @Autowired
    private ZyyjKnowledgepointService knowledgepointService;

    @ApiOperation(value = "查询题库的所有数据")
    @GetMapping("/knowledgepoint")
    public CommonreturnType ConditionQuery(@ApiParam("科目id")@RequestParam(value = "courseId",required = false) Integer courseId,
                                           @ApiParam("章节id")@RequestParam(value = "chapterId",required = false) Integer chapterId,
                                           @ApiParam("要求id")@RequestParam(value = "requirId",required = false) Integer requirId,
                                           @ApiParam("知识点名字")@RequestParam(value = "name",required = false) String name) {
        List<KnowledgepointVo> list = knowledgepointService.ConditionQuery(courseId,chapterId,requirId,name);
        return CommonreturnType.create(list);
    }

    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/knowledgepoint/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getKnowledgepointByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                                    @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<KnowledgepointVo> pageInfo = knowledgepointService.getKnowledgepointByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新题库的数据")
    @PutMapping("/knowledgepoint")
    public CommonreturnType updateKnowledgepoint(@RequestBody ZyyjKnowledgepointPo knowledgepointPo) throws BusinessException {
        boolean result = knowledgepointService.updateKnowledgepoint(knowledgepointPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除题库的数据")
    @DeleteMapping("/knowledgepoint")
    public CommonreturnType deleteKnowledgepoint(@ApiParam(value = "题库编号",required = true) @RequestParam(value = "knowIds") Integer[] knowIds) throws BusinessException {
        boolean result = knowledgepointService.deleteKnowledgepoint(knowIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入新的题库数据")
    @PostMapping("/knowledgepoint")
    public CommonreturnType insertKnowledgepoint(@RequestBody ZyyjKnowledgepointPo knowledgepointPo) throws BusinessException {
        boolean result = knowledgepointService.insertKnowledgepoint(knowledgepointPo);
        return CommonreturnType.create(result);
    }
}
