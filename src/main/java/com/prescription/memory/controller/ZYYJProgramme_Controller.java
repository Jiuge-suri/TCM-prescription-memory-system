package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.prescription.memory.entity.po.ZyyjProgrammePo;
import com.prescription.memory.entity.vo.ProgrammeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjProgrammeService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "学院秘书--练习管理--练习方案管理")
public class ZYYJProgramme_Controller extends BaseController{
    @Autowired
    ZyyjProgrammeService service;

    @GetMapping("/programme")
    @ApiOperation(value = "条件查询练习方案数据")
    public CommonreturnType ConditionQuery(@ApiParam("方案名") @RequestParam(value = "name",required = false) String name){
        List<ProgrammeVo> all = service.ConditionQuery(name);
        return CommonreturnType.create(all);
    }
    @GetMapping("/programme/pageNum/{pageNum}/pageSize/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                         @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<ProgrammeVo> pageInfo = service.selectByPage(pageNum, pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/programme")
    public CommonreturnType updateProgramme(@RequestBody ZyyjProgrammePo programmePo) throws BusinessException {
        boolean result = service.updateProgramme(programmePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/programme")
    public CommonreturnType deleteProgramme(@ApiParam(value = "编号",required = true) @RequestParam(value = "checkpointId") Integer[] programmeIds) throws BusinessException {
        boolean result = service.deleteProgrammeById(programmeIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/programme")
    public CommonreturnType insertProgramme(@RequestBody ZyyjProgrammePo programmePo) throws BusinessException {
        boolean result = service.insertProgramme(programmePo);
        return CommonreturnType.create(result);
    }
}
