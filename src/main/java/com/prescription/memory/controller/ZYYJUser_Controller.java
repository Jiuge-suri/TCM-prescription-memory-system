package com.prescription.memory.controller;

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
    ZyyjUserService service = new ZyyjUserServiceImpl();

    @GetMapping("/user")
    @ApiOperation(value = "多条件查询")
    public CommonreturnType ConditionQuery(@ApiParam(value = "用户名字",required = false) @RequestParam(value = "name",required = false) String name,
                                   @ApiParam(value = "部门id",required = false)@RequestParam(value = "departmentId",required = false) Integer departmentId){
        List<UserVo> list = service.ConditionQuery(name,departmentId);
        return CommonreturnType.create(list);
    }
    @GetMapping("/user/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页查询")
    public CommonreturnType selectByPage(@PathVariable(value = "pageNum") Integer pageNum,
                                         @PathVariable(value = "pageSize") Integer pageSize){
        PageInfo<UserVo> pageInfo = service.selectByPage(pageNum, pageSize);
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
    public CommonreturnType deleteUser(@ApiParam(value = "用户id",required = true)
                                       @RequestParam(value = "userId") Integer[] userIds) throws BusinessException {
        boolean result = service.deleteUser(userIds);
        return CommonreturnType.create(result);
    }
    @PostMapping("/user")
    @ApiOperation(value = "插入用户")
    public CommonreturnType insertUser(@RequestBody ZyyjUserPo userPo) throws BusinessException {
        boolean result = service.insertUser(userPo);
        return CommonreturnType.create(result);
    }
}
