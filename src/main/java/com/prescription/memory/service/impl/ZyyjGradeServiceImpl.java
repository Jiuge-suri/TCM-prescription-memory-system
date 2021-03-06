package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjMajorDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjGradePo;
import com.prescription.memory.dao.ZyyjGradeDao;
import com.prescription.memory.entity.po.ZyyjMajorPo;
import com.prescription.memory.entity.vo.GradeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ZyyjGradeServiceImpl extends ServiceImpl<ZyyjGradeDao, ZyyjGradePo> implements ZyyjGradeService {
    @Autowired
    ZyyjGradeDao gradeDao;

    @Override
    public Page<GradeVo> getGradeByPage(Integer majorId) {
        return gradeDao.getGradeByPage(majorId);
    }

    @Override
    public List<ZyyjGradePo> getAll(Integer majorId) {
        LambdaQueryWrapper<ZyyjGradePo> queryWrapper = new LambdaQueryWrapper<>();
        if (majorId != null && majorId != 0){
            queryWrapper.eq(ZyyjGradePo::getMajorId,majorId);
        }
        List<ZyyjGradePo> list = gradeDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public boolean insertGrade(ZyyjGradePo gradePo) {
        int count = gradeDao.insert(gradePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGrade(ZyyjGradePo gradePo) throws BusinessException {
        ZyyjGradePo gradePo1 = gradeDao.selectById(gradePo.getMajorId());
        if (gradePo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = gradeDao.updateById(gradePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteGrade(Integer[] gradeIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < gradeIds.length; i++){
            ZyyjGradePo gradePo = gradeDao.selectById(gradeIds[i]);
            if (gradePo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += gradeDao.deleteById(gradeIds[i]);
        }

        if (count != gradeIds.length){
            return false;
        }
        return true;
    }
}
