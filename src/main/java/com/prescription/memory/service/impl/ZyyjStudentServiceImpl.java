package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.*;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.*;
import com.prescription.memory.entity.vo.StudentVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bouncycastle.util.Integers;
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
public class ZyyjStudentServiceImpl extends ServiceImpl<ZyyjStudentDao, ZyyjStudentPo> implements ZyyjStudentService {
    @Autowired
    ZyyjStudentDao studentDao;


    @Override
    public Page<StudentVo> getStudentByPage(Integer majorId, Integer gradeId, Integer classId, Integer sex, String account, String name, Integer collegeId) {
        return studentDao.getStudentByPage(majorId,gradeId,classId,sex,account,name,collegeId);
    }

    @Override
    public boolean insertStudent(ZyyjStudentPo stuPo) {
        int count = studentDao.insert(stuPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStudent(ZyyjStudentPo stuPo) throws BusinessException {
        ZyyjStudentPo studentPo = studentDao.selectById(stuPo.getStuId());
        if (studentPo == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = studentDao.updateById(stuPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteStudent(Integer[] stuIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < stuIds.length; i++){
            ZyyjStudentPo studentPo = studentDao.selectById(stuIds[i]);
            if (studentPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += studentDao.deleteById(stuIds[i]);
        }
        if (count != stuIds.length){
            return false;
        }
        return true;
    }
}
