package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("科目id")@RequestParam(value = "courseId",required = false) Integer courseId,
                                           @ApiParam("章节名称")@RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(pageNum,pageSize);
        Page<ChapterVo> page = service.getChapterByPage(courseId, name);
        PageInfo<ChapterVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @GetMapping("/chapter/getall")
    @ApiOperation(value = "查询章节所有数据")
    public CommonreturnType getAll(@ApiParam("科目id")@RequestParam(value = "courseId",required = false) Integer courseId){
        return CommonreturnType.create(service.getAll(courseId));
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
                                          @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = service.deleteChapter(deleteArr.getArray());

        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/chapter")
    public CommonreturnType insertChapter(@RequestBody ZyyjChapterPo chapterPo){
        boolean result = service.insertChapter(chapterPo);
        return CommonreturnType.create(result);
    }
}
