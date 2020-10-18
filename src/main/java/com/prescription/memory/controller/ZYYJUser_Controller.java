package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.DeleteArr;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.prescription.memory.entity.vo.UserVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.service.ZyyjUserService;
import com.prescription.memory.service.impl.ZyyjUserServiceImpl;
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
@Api(tags = "管理人员--用户管理--用户管理")
public class ZYYJUser_Controller extends BaseController{
    @Autowired
    ZyyjUserService service;

    @GetMapping("/user")
    @ApiOperation(value = "多条件查询")
    public CommonreturnType ConditionQuery(@ApiParam(value = "页码",required = true) @RequestParam(value = "pageNum") Integer pageNum,
                                           @ApiParam(value = "每页数据量",required = true) @RequestParam(value = "pageSize")Integer pageSize,
                                    @ApiParam(value = "用户名字",required = false) @RequestParam(value = "name",required = false) String name,
                                   @ApiParam(value = "部门id",required = false)@RequestParam(value = "departmentId",required = false) Integer departmentId){
        PageHelper.startPage(pageNum, pageSize);
        Page<UserVo> page = service.getUserByPage(name,departmentId);
        PageInfo<UserVo> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @PutMapping("/user")
    @ApiOperation(value = "修改用户")
    public CommonreturnType updateUser(@RequestBody ZyyjUserPo userPo) throws BusinessException {
        boolean result = service.updateUser(userPo);
        return CommonreturnType.create(result);
    }
    @DeleteMapping("/user")
    @ApiOperation(value = "删除用户")
    public CommonreturnType deleteUser(@ApiParam(value = "用户id")
                                       @RequestBody DeleteArr deleteArr) throws BusinessException {

        boolean result = service.deleteUser(deleteArr.getArray());

        return CommonreturnType.create(result);
    }
    @PostMapping("/user")
    @ApiOperation(value = "插入用户")
    public CommonreturnType insertUser(@RequestBody ZyyjUserPo userPo) throws BusinessException {
        boolean result = service.insertUser(userPo);
        return CommonreturnType.create(result);
    }
}
