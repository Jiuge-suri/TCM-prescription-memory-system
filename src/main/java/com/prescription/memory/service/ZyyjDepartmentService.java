package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.DepartmentVo;
import com.prescription.memory.entity.vo.DeptRespNodeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.utils.CommonreturnType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjDepartmentService extends IService<ZyyjDepartmentPo> {

    List<DepartmentVo> ConditionQuery(String name);

    Page<DepartmentVo> getDepartmentByPage(String name);

    List<DeptRespNodeVo> deptTreeList();

    boolean addDept(ZyyjDepartmentPo departmentPo);

    boolean deleteDept(Integer[] departmentIds) throws BusinessException;

    boolean updateDept(ZyyjDepartmentPo departmentPo) throws BusinessException;

    PageInfo<DepartmentVo> selectByPage(Integer pageNum, Integer pageSize);
}
