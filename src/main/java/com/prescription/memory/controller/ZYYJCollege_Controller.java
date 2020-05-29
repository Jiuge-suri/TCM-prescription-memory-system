package com.prescription.memory.controller;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.entity.vo.CollegeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjCollegeService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/12
 */
@RestController
@Api(tags = "管理人员--学院管理")
public class ZYYJCollege_Controller extends BaseController {
    @Autowired
    private ZyyjCollegeService collegeService;

    @ApiOperation(value = "条件查询学院数据")
    @GetMapping("/college")
    public CommonreturnType ConditionQuery(@ApiParam(value = "学院id") @RequestParam(value = "collegeId",required = false) Integer collegeId) {
        List<CollegeVo> list = collegeService.ConditionQuery(collegeId);
        return CommonreturnType.create(list);
    }
    @ApiOperation(value = "多表关联分页查询")
    @GetMapping("/college/{pageNum}/{pageSize}")
    public CommonreturnType getCollegeByPage(@ApiParam(value = "页码",required = true) @PathVariable(value = "pageNum") Integer pageNum,
                                             @ApiParam(value = "每页数据量",required = true) @PathVariable(value = "pageSize")Integer pageSize){
        PageInfo<CollegeVo> pageInfo = collegeService.getCollegeByPage(pageNum,pageSize);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "更新学院的数据")
    @PutMapping("/college")
    public CommonreturnType updateCollege(@RequestBody ZyyjCollegePo collegePo) throws BusinessException {
        boolean result = collegeService.updateCollege(collegePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "批量删除学院的数据")
    @DeleteMapping("/college")
    public CommonreturnType deleteCollege(@ApiParam(value = "学院编号数组",required = true)
                                              @RequestParam(value = "collegeIds") Integer[] collegeIds) throws BusinessException {

        boolean result = collegeService.deleteCollege(collegeIds);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "插入新的学院数据")
    @PostMapping("/college")
    public CommonreturnType insertCollege(@RequestBody ZyyjCollegePo collegePo) throws BusinessException {
        boolean result = collegeService.insertCollege(collegePo);
        return CommonreturnType.create(result);
    }
}
