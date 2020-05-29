package com.prescription.memory.controller;

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
    public CommonreturnType ConditionQuery(@ApiParam("关卡名") @RequestParam(value = "name",required = false) String name) {
        List<CheckpointVo> list = checkpointService.ConditionQuery(name);
        return CommonreturnType.create(list);
    }
    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/checkpoint/{pageNum}/{pageSize}")
    public CommonreturnType getCheckpointByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                                @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<CheckpointVo> pageInfo = checkpointService.getCheckpointByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新数据")
    @PutMapping("/checkpoint")
    public CommonreturnType updateCheckpoint(@RequestBody ZyyjCheckpointPo checkpointPo) throws BusinessException {
        boolean result = checkpointService.updateCheckpoint(checkpointPo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/checkpoint")
    public CommonreturnType deleteCheckpoint(@ApiParam(value = "编号",required = true) @RequestParam(value = "checkpointId") Integer[] checkpointIds) throws BusinessException {
        boolean result = checkpointService.deleteCheckpoint(checkpointIds);
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
