package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjCollegeDao;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
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
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                           @ApiParam(value = "学院id") @RequestParam(value = "collegeId",required = false)Integer collegeId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<CollegeVo> page = collegeService.getCollegeByPage(collegeId);
        PageInfo<CollegeVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "获得所有的学院数据")
    @GetMapping("/college/getall")
    public CommonreturnType getAll(){
        List<ZyyjCollegePo> all = collegeService.getAll();
        return CommonreturnType.create(all);
    }
    @ApiOperation(value = "更新学院的数据")
    @PutMapping("/college")
    public CommonreturnType updateCollege(@RequestBody ZyyjCollegePo collegePo) throws BusinessException {
        boolean result = collegeService.updateCollege(collegePo);
        return CommonreturnType.create(result);
    }

    @ApiOperation(value = "批量删除学院的数据")
    @DeleteMapping("/college")
    public CommonreturnType deleteCollege(@ApiParam(value = "学院编号数组")
                                              @RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result = collegeService.deleteCollege(deleteArr.getArray());
        return CommonreturnType.create(result);
    }
    @ApiOperation(value = "插入新的学院数据")
    @PostMapping("/college")
    public CommonreturnType insertCollege(@RequestBody ZyyjCollegePo collegePo) throws BusinessException {
        boolean result = collegeService.insertCollege(collegePo);
        return CommonreturnType.create(result);
    }
}
