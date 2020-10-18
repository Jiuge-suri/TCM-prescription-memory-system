package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjDepartmentDao;
import com.prescription.memory.dao.ZyyjGradeDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjClassPo;
import com.prescription.memory.dao.ZyyjClassDao;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.entity.po.ZyyjGradePo;
import com.prescription.memory.entity.vo.ClassVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjClassService;
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
public class ZyyjClassServiceImpl extends ServiceImpl<ZyyjClassDao, ZyyjClassPo> implements ZyyjClassService {
    @Autowired
    ZyyjClassDao classDao;
    @Autowired
    ZyyjGradeDao gradeDao;
    @Autowired
    ZyyjDepartmentDao departmentDao;


    @Override
    public Page<ClassVo> getClassByPage(Integer gradeId) {
        return classDao.getClassByPage(gradeId);
    }

    @Override
    public List<ZyyjClassPo> getAll(Integer gradeId) {
        LambdaQueryWrapper<ZyyjClassPo> queryWrapper = new LambdaQueryWrapper<>();
        if (gradeId != null && gradeId != 0){
            queryWrapper.eq(ZyyjClassPo::getGradeId,gradeId);
        }
        List<ZyyjClassPo> list = classDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public boolean insertClass(ZyyjClassPo classPo) {
        int count = classDao.insert(classPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateClass(ZyyjClassPo classPo) throws BusinessException {
       ZyyjClassPo zyyjClassPo = classDao.selectById(classPo.getClassId());
       if (zyyjClassPo == null){
           throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
       }
       int count = classDao.updateById(classPo);
       if (count != 1){
           return false;
       }
        return true;
    }

    @Override
    public boolean deleteClass(Integer[] classIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < classIds.length; i++){
            ZyyjClassPo classPo = classDao.selectById(classIds[i]);
            if (classPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += classDao.deleteById(classIds[i]);
        }

        if (count != classIds.length){
            return false;
        }
        return true;
    }
}
