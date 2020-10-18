package com.prescription.memory.service.impl;

import ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.prescription.memory.entity.po.ZyyjProgrammePo;
import com.prescription.memory.dao.ZyyjProgrammeDao;
import com.prescription.memory.entity.vo.ProgrammeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjProgrammeService;
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
public class ZyyjProgrammeServiceImpl extends ServiceImpl<ZyyjProgrammeDao, ZyyjProgrammePo> implements ZyyjProgrammeService {
    @Autowired
    ZyyjProgrammeDao programmeDao;

    @Override
    public Page<ProgrammeVo> getProgrammeByPage(String name) {
        return programmeDao.getProgrammeByPage(name);
    }

    @Override
    public List<ZyyjProgrammePo> getAll() {
        return programmeDao.selectList(null);
    }

    @Override
    public boolean insertProgramme(ZyyjProgrammePo programmePo) {
        int count = programmeDao.insert(programmePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProgramme(ZyyjProgrammePo programmePo) throws BusinessException {
        ZyyjProgrammePo programmePo1 = programmeDao.selectById(programmePo.getProgrammeId());
        if (programmePo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = programmeDao.updateById(programmePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProgrammeById(Integer[] programmeIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < programmeIds.length; i++){
            ZyyjProgrammePo programmePo = programmeDao.selectById(programmeIds[i]);
            if (programmePo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += programmeDao.deleteById(programmeIds[i]);
        }
        if (count != programmeIds.length){
            return false;
        }
        return true;
    }
}
