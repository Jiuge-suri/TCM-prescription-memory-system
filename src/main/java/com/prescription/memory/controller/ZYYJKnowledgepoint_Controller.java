package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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

    @ApiOperation(value = "多条件查询知识点数据")
    @GetMapping("/knowledgepoint")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("科目id")@RequestParam(value = "courseId",required = false) Integer courseId,
                                           @ApiParam("章节id")@RequestParam(value = "chapterId",required = false) Integer chapterId,
                                           @ApiParam("要求id")@RequestParam(value = "requirId",required = false) Integer requirId,
                                           @ApiParam("知识点名字")@RequestParam(value = "name",required = false) String name) {
        PageHelper.startPage(pageNum,pageSize);
        Page<KnowledgepointVo> page = knowledgepointService.getKnowledgepointByPage(courseId,chapterId,requirId,name);
        PageInfo<KnowledgepointVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查询所有知识点")
    @GetMapping("/knowledgepoint/getall")
    public CommonreturnType getAll(@ApiParam("章节id")@RequestParam(value = "chapterId",required = false) Integer chapterId){
        return CommonreturnType.create(knowledgepointService.getAll(chapterId));
    }
    @ApiOperation(value = "更新知识点的数据")
    @PutMapping("/knowledgepoint")
    public CommonreturnType updateKnowledgepoint(@RequestBody ZyyjKnowledgepointPo knowledgepointPo) throws BusinessException {
        boolean result = knowledgepointService.updateKnowledgepoint(knowledgepointPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除知识点的数据")
    @DeleteMapping("/knowledgepoint")
    public CommonreturnType deleteKnowledgepoint(@RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = knowledgepointService.deleteKnowledgepoint(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入新的知识点数据")
    @PostMapping("/knowledgepoint")
    public CommonreturnType insertKnowledgepoint(@RequestBody ZyyjKnowledgepointPo knowledgepointPo) throws BusinessException {
        boolean result = knowledgepointService.insertKnowledgepoint(knowledgepointPo);
        return CommonreturnType.create(result);
    }
}
