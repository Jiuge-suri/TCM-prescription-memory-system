package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.entity.vo.CollegeVo;
import com.prescription.memory.entity.vo.DepartmentVo;
import com.prescription.memory.entity.vo.DeptRespNodeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjDepartmentService;
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
@Api(tags = "管理人员--用户管理--部门管理")
public class ZYYJDepartment_Controller extends BaseController{
    @Autowired
    ZyyjDepartmentService departmentService;

    @GetMapping("/department")
    @ApiOperation(value = "条件查询部门数据")
    public CommonreturnType ConditonQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                          @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                          @ApiParam(value = "部门名称") @RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(pageNum,pageSize);
        Page<DepartmentVo> page = departmentService.getDepartmentByPage(name);
        PageInfo<DepartmentVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);

    }
    @GetMapping("/department/tree")
    @ApiOperation(value = "获取部门树")
    public CommonreturnType getTree(){
        List<DeptRespNodeVo> tree = departmentService.deptTreeList();
        return CommonreturnType.create(tree);
    }
    @PostMapping("/department")
    @ApiOperation(value = "添加部门")
    public CommonreturnType addDept(@RequestBody ZyyjDepartmentPo departmentPo){
        boolean result = departmentService.addDept(departmentPo);
        return CommonreturnType.create(result);
    }
    @DeleteMapping("/department")
    @ApiOperation(value = "删除部门")
    public CommonreturnType deleteDept(@RequestBody DeleteArr deleteArr) throws BusinessException {
        boolean result =  departmentService.deleteDept(deleteArr.getArray());
        return CommonreturnType.create(result);
    }
    @PutMapping("/department")
    @ApiOperation(value = "修改部门")
    public CommonreturnType updateDept(@RequestBody ZyyjDepartmentPo departmentPo) throws BusinessException {
        boolean result = departmentService.updateDept(departmentPo);
        return CommonreturnType.create(result);
    }
}
