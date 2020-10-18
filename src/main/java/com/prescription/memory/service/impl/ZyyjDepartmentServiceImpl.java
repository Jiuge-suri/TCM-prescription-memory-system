package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjCollegeDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.dao.ZyyjDepartmentDao;
import com.prescription.memory.entity.vo.DepartmentVo;
import com.prescription.memory.entity.vo.DeptRespNodeChild;
import com.prescription.memory.entity.vo.DeptRespNodeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Service
public class ZyyjDepartmentServiceImpl extends ServiceImpl<ZyyjDepartmentDao, ZyyjDepartmentPo> implements ZyyjDepartmentService {
    @Autowired
    ZyyjDepartmentDao departmentDao;
    @Autowired
    ZyyjCollegeDao collegeDao;
    @Override
    public List<DepartmentVo> ConditionQuery(String name) {
        LambdaQueryWrapper<ZyyjDepartmentPo> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null && name != ""){
            queryWrapper.like(ZyyjDepartmentPo::getName,name);
        }
        List<ZyyjDepartmentPo> list = departmentDao.selectList(queryWrapper);
        List<DepartmentVo> result_list = new ArrayList<>();
        for (ZyyjDepartmentPo departmentPo: list){
            DepartmentVo departmentVo = new DepartmentVo();
            ZyyjDepartmentPo parent = departmentDao.selectById(departmentPo.getParentId());
            ZyyjCollegePo collegePo = collegeDao.selectById(departmentPo.getCollegeId());
            BeanUtils.copyProperties(departmentPo,departmentVo);
            if (collegePo != null){
                departmentVo.setCollegeName(collegePo.getName());
            }
            if (parent != null){
                departmentVo.setParentName(parent.getName());
            }
            result_list.add(departmentVo);
        }
        return result_list;
    }

    @Override
    public Page<DepartmentVo> getDepartmentByPage(String name) {
        return departmentDao.getDepartmentByPage(name);
    }

    @Override
    public boolean addDept(ZyyjDepartmentPo departmentPo) {
        int count = departmentDao.insert(departmentPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteDept(Integer[] departmentIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < departmentIds.length; i++){
            try {
                count += departmentDao.deleteById(departmentIds[i]);
            } catch (Exception e) {
                throw new BusinessException(EmBusinessError.NOTALLOWDELETE);
            }
        }
        if (count != departmentIds.length){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateDept(ZyyjDepartmentPo departmentPo) throws BusinessException {
        ZyyjDepartmentPo departmentPo1 = departmentDao.selectById(departmentPo.getDepartmentId());
        if (departmentPo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = departmentDao.updateById(departmentPo);
        if (count != 1){
            return false;
        }
        return true;
    }
    @Override
    public PageInfo<DepartmentVo> selectByPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DepartmentVo> list = ConditionQuery(null);
        PageInfo<DepartmentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<DeptRespNodeVo> deptTreeList() {
        List<ZyyjDepartmentPo> list = departmentDao.selectList(null);
        DeptRespNodeVo deptRespNodeVo = new DeptRespNodeVo();
        deptRespNodeVo.setDepartmentId(0);
        deptRespNodeVo.setName("默认顶级部门");
        deptRespNodeVo.setChildren(getTree(list));
        List<DeptRespNodeVo> result = new ArrayList<>();
        result.add(deptRespNodeVo);
        return result;
    }

    private List<DeptRespNodeVo> getTree(List<ZyyjDepartmentPo> all){
        List<DeptRespNodeVo> list = new ArrayList<>();
        for (ZyyjDepartmentPo departmentPo: all){
            if (departmentPo.getParentId().equals(0)){
                DeptRespNodeVo deptRespNodeVo = new DeptRespNodeVo();
                BeanUtils.copyProperties(departmentPo,deptRespNodeVo);
                deptRespNodeVo.setChildren(getChild(departmentPo.getDepartmentId(), all));
                list.add(deptRespNodeVo);
            }
        }
        return list;
    }
    private List<DeptRespNodeChild> getChild(Integer departmentId, List<ZyyjDepartmentPo> all){
        int flag = 1;
        List<DeptRespNodeChild> list = new ArrayList<>();
        for (ZyyjDepartmentPo departmentPo: all){
            if (departmentPo.getParentId().equals(departmentId)){
                DeptRespNodeChild deptRespNodeChild = new DeptRespNodeChild();
                BeanUtils.copyProperties(departmentPo,deptRespNodeChild);
                //deptRespNodeVo.setChildren(getChild(departmentPo.getDepartmentId(), all));
                flag = 0;
                list.add(deptRespNodeChild);
            }
        }
        if (flag==1){
            DeptRespNodeChild deptRespNodeChild = new DeptRespNodeChild();
            ZyyjDepartmentPo departmentPo = departmentDao.selectById(departmentId);
            BeanUtils.copyProperties(departmentPo,deptRespNodeChild);
            list.add(deptRespNodeChild);
        }
        return list;
    }
}
