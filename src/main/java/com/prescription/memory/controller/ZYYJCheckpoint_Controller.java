package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.prescription.memory.entity.vo.CheckpointVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjCheckpointService;
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
@Api(tags = "学院秘书--练习管理--练习关卡管理")
public class ZYYJCheckpoint_Controller extends BaseController{
    @Autowired
    private ZyyjCheckpointService checkpointService;

    @ApiOperation(value = "条件查询关卡数据")
    @GetMapping("/checkpoint")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                            @ApiParam("关卡名") @RequestParam(value = "name",required = false) String name) {
        PageHelper.startPage(pageNum,pageSize);
        Page<CheckpointVo> page = checkpointService.getCheckpointByPage(name);
        PageInfo<CheckpointVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "查询关卡所有的数据")
    @GetMapping("/checkpoint/getall")
    public CommonreturnType getAll(){
        return CommonreturnType.create(checkpointService.getAll());
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("/checkpoint")
    public CommonreturnType updateCheckpoint(@ApiParam(value = "编号") @RequestBody ZyyjCheckpointPo checkpointPo) throws BusinessException {
        boolean result = checkpointService.updateCheckpoint(checkpointPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/checkpoint")
    public CommonreturnType deleteCheckpoint(@ApiParam(value = "编号",required = true) @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = checkpointService.deleteCheckpoint(deleteArr.getArray());
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/checkpoint")
    public CommonreturnType insertCheckpoint(@RequestBody ZyyjCheckpointPo checkpointPo) throws BusinessException {
        //将Vo转换成Po
        boolean result = checkpointService.insertCheckpoint(checkpointPo);
        return CommonreturnType.create(result);
    }
}
