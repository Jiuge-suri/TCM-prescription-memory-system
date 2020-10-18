package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamProgramPo;
import com.prescription.memory.dao.ZyyjExamProgramDao;
import com.prescription.memory.entity.vo.ExamProgramVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjExamProgramService;
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
public class ZyyjExamProgramServiceImpl extends ServiceImpl<ZyyjExamProgramDao, ZyyjExamProgramPo> implements ZyyjExamProgramService {
    @Autowired
    ZyyjExamProgramDao examProgramDao;


    @Override
    public Page<ExamProgramVo> getExamProgrammeByPage(String name) {
        return examProgramDao.getExamProgrammeByPage(name);
    }

    @Override
    public List<ZyyjExamProgramPo> getAll() {
        return examProgramDao.selectList(null);
    }

    @Override
    public boolean insertExamProgram(ZyyjExamProgramPo examProgramPo) {
        int count = examProgramDao.insert(examProgramPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateExamProgram(ZyyjExamProgramPo examProgramPo) throws BusinessException {
        ZyyjExamProgramPo examProgramPo1 = examProgramDao.selectById(examProgramPo.getProgramId());
        if (examProgramPo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = examProgramDao.updateById(examProgramPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteExamProgram(Integer[] examProgramIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < examProgramIds.length; i++){
            ZyyjExamProgramPo examProgramPo = examProgramDao.selectById(examProgramIds[i]);
            if (examProgramPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += examProgramDao.deleteById(examProgramIds[i]);
        }
        if (count != examProgramIds.length){
            return false;
        }
        return true;
    }
}
