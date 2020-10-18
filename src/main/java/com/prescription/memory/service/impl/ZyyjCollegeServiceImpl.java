package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjUniversityDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.dao.ZyyjCollegeDao;
import com.prescription.memory.entity.po.ZyyjUniversityPo;
import com.prescription.memory.entity.vo.CollegeVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjCollegeService;
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
public class ZyyjCollegeServiceImpl extends ServiceImpl<ZyyjCollegeDao, ZyyjCollegePo> implements ZyyjCollegeService {
    @Autowired
    ZyyjCollegeDao collegeDao;

    @Override
    public Page<CollegeVo> getCollegeByPage(Integer collegeId) {
        Page<CollegeVo> page = collegeDao.getCollegeByPage(collegeId);
        return page;
    }

    @Override
    public List<ZyyjCollegePo> getAll() {
        return collegeDao.selectList(null);
    }

    @Override
    public boolean insertCollege(ZyyjCollegePo collegePo){
        int count = collegeDao.insert(collegePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCollege(ZyyjCollegePo collegePo) throws BusinessException {
        ZyyjCollegePo collegePo1 = collegeDao.selectById(collegePo.getCollegeId());
        if (collegePo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = collegeDao.updateById(collegePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCollege(Integer[] collegeIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < collegeIds.length; i++){
            try {
                count = count + collegeDao.deleteById(collegeIds[i]);
            } catch (Exception e) {
                throw new BusinessException(EmBusinessError.NOTALLOWDELETE);
            }
        }
        if (count != collegeIds.length){
            return false;
        }
        return true;
    }
}
