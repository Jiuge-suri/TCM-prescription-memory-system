package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjProgrammeDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.prescription.memory.dao.ZyyjCheckpointDao;
import com.prescription.memory.entity.po.ZyyjProgrammePo;
import com.prescription.memory.entity.vo.CheckpointVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjCheckpointService;
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
public class ZyyjCheckpointServiceImpl extends ServiceImpl<ZyyjCheckpointDao, ZyyjCheckpointPo> implements ZyyjCheckpointService {
    @Autowired
    ZyyjCheckpointDao checkpointDao;
    @Autowired
    ZyyjProgrammeDao programmeDao;

    @Override
    public Page<CheckpointVo> getCheckpointByPage(String name) {
        return checkpointDao.getCheckpointByPage(name);
    }

    @Override
    public List<ZyyjCheckpointPo> getAll() {
        return checkpointDao.selectList(null);
    }

    @Override
    public boolean insertCheckpoint(ZyyjCheckpointPo checkpointPo) {
        int count = checkpointDao.insert(checkpointPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCheckpoint(ZyyjCheckpointPo checkpointPo) throws BusinessException {
        ZyyjCheckpointPo po = checkpointDao.selectById(checkpointPo.getCheckpointId());
        if (po == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = checkpointDao.updateById(checkpointPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCheckpoint(Integer[] checkpointIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < checkpointIds.length; i++){
            ZyyjCheckpointPo po = checkpointDao.selectById(checkpointIds[i]);
            if (po == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += checkpointDao.deleteById(checkpointIds[i]);
        }
        if (count != checkpointIds.length){
            return false;
        }
        return true;
    }
}
