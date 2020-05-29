package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjChapterPo;
import com.prescription.memory.entity.vo.ChapterVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjChapterService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/18
 */
@RestController
@Api(tags = "教师--分类管理--章节管理")
public class ZyyjChapter_Controller extends BaseController{
    @Autowired
    ZyyjChapterService service;

    @GetMapping("/chapter")
    @ApiOperation(value = "多条件查询章节数据")
    public CommonreturnType ConditionQuery(@ApiParam("科目id")@RequestParam(value = "courseId",required = false) Integer courseId,
                                           @ApiParam("章节名称")@RequestParam(value = "name",required = false) String name){
        List<ChapterVo> all = service.ConditionQuery(courseId, name);
        return CommonreturnType.create(all);
    }
    @GetMapping("/chapter/pageNum/{pageNum}/pageSize/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                         @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ChapterVo> pageInfo = service.getChapterByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/chapter")
    public CommonreturnType updateChapter(@RequestBody ZyyjChapterPo chapterPo) throws BusinessException {
        boolean result = service.updateChapter(chapterPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/chapter")
    public CommonreturnType deleteChapter(@ApiParam(value = "编号")
                                          @RequestParam(value = "classIds",required = true) Integer[] chapterIds) throws BusinessException {
        boolean result = service.deleteChapter(chapterIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/chapter")
    public CommonreturnType insertChapter(@RequestBody ZyyjChapterPo chapterPo){
        boolean result = service.insertChapter(chapterPo);
        return CommonreturnType.create(result);
    }
}
