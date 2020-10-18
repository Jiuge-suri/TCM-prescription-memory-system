package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjExamProgramDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamLevelPo;
import com.prescription.memory.dao.ZyyjExamLevelDao;
import com.prescription.memory.entity.po.ZyyjExamProgramPo;
import com.prescription.memory.entity.vo.ExamLevelVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjExamLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.checkerframework.checker.units.qual.A;
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
public class ZyyjExamLevelServiceImpl extends ServiceImpl<ZyyjExamLevelDao, ZyyjExamLevelPo> implements ZyyjExamLevelService {
    @Autowired
    ZyyjExamLevelDao examLevelDao;
    @Autowired
    ZyyjExamProgramDao examProgramDao;


    @Override
    public Page<ExamLevelVo> getExamLevelByPage(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        return examLevelDao.getExamLevelByPage(name);
    }

    @Override
    public List<ZyyjExamLevelPo> getAll() {
        return examLevelDao.selectList(null);
    }

    @Override
    public boolean insertExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException {
        int count = examLevelDao.insert(examLevelPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException {
        examLevelDao.selectById(examLevelPo.getLevelId());
        int count = examLevelDao.updateById(examLevelPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteExamLevel(Integer[] examLevelIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < examLevelIds.length; i++){
            examLevelDao.selectById(examLevelIds[i]);
            count += examLevelDao.deleteById(examLevelIds[i]);
        }

        if (count != examLevelIds.length){
            return false;
        }
        return true;
    }
}
