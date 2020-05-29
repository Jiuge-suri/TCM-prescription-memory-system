package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    ZyyjClassDao classDao;
    @Autowired
    ZyyjGradeDao gradeDao;
    @Autowired
    ZyyjCollegeDao collegeDao;
    @Autowired
    ZyyjUniversityDao universityDao;
    @Autowired
    ZyyjStudentDao studentDao;
    @Autowired
    ZyyjMajorDao majorDao;
    @Override
    public List<StudentVo> ConditionQuery(Integer majorId, Integer gradeId, Integer classId, Integer sex, String account, String name){
        LambdaQueryWrapper<ZyyjStudentPo> queryWrapper = new LambdaQueryWrapper<>();
        if (majorId != null && majorId != 0){
            queryWrapper.eq(ZyyjStudentPo::getMajorId,majorId);
        }
        if (gradeId != null && gradeId != 0){
            queryWrapper.eq(ZyyjStudentPo::getGradeId,gradeId);
        }
        if (classId != null && classId != 0){
            queryWrapper.eq(ZyyjStudentPo::getClassId,classId);
        }
        if (sex != null){
            queryWrapper.eq(ZyyjStudentPo::getGender,sex);
        }
        if (account != null && account != ""){
            queryWrapper.like(ZyyjStudentPo::getAccount,account);
        }
        if (name != null && name != ""){
            queryWrapper.like(ZyyjStudentPo::getName,name);
        }
        List<ZyyjStudentPo> list = studentDao.selectList(queryWrapper);
        List<StudentVo> result_list = new ArrayList<>();
        for (ZyyjStudentPo studentPo: list){
            StudentVo studentVo = new StudentVo();
            ZyyjClassPo classPo = classDao.selectById(studentPo.getClassId());
            ZyyjGradePo gradePo = gradeDao.selectById(studentPo.getGradeId());
            ZyyjCollegePo collegePo = collegeDao.selectById(studentPo.getCollegeId());
            ZyyjUniversityPo universityPo = universityDao.selectById(studentPo.getUniversityId());
            ZyyjMajorPo majorPo = majorDao.selectById(studentPo.getMajorId());
            BeanUtils.copyProperties(studentPo,studentVo);
            if (classPo != null){
                studentVo.setClassName(classPo.getName());
            }
            if (gradePo != null){
                studentVo.setGradeName(gradePo.getName());
            }
            if (collegePo != null){
                studentVo.setCollegeName(collegePo.getName());
            }
            if (universityPo != null){
                studentVo.setUniversityName(universityPo.getName());
            }
            if (majorPo != null){
                studentVo.setMajorName(majorPo.getName());
            }
            result_list.add(studentVo);
        }
        return result_list;
    }

    @Override
    public PageInfo<StudentVo> getStudentByPage(Integer pageNum, Integer pageSize) throws BusinessException {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentVo> list = ConditionQuery(null,null,null,null,null,null);
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
