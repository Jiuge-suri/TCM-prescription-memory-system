package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("方案名") @RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(pageNum,pageSize);
        Page<ProgrammeVo> page = service.getProgrammeByPage(name);
        PageInfo<ProgrammeVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @GetMapping("/programme/getall")
    @ApiOperation(value = "查询所有的练习方案数据")
    public CommonreturnType getAll(){
        return CommonreturnType.create(service.getAll());
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/programme")
    public CommonreturnType updateProgramme(@RequestBody ZyyjProgrammePo programmePo) throws BusinessException {
        boolean result = service.updateProgramme(programmePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/programme")
    public CommonreturnType deleteProgramme(@ApiParam(value = "编号") @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = service.deleteProgrammeById(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/programme")
    public CommonreturnType insertProgramme(@RequestBody ZyyjProgrammePo programmePo) throws BusinessException {
        boolean result = service.insertProgramme(programmePo);
        return CommonreturnType.create(result);
    }
}
