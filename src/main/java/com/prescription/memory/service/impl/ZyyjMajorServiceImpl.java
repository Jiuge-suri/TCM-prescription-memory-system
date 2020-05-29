package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjCollegeDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.entity.po.ZyyjMajorPo;
import com.prescription.memory.dao.ZyyjMajorDao;
import com.prescription.memory.entity.vo.MajorVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjMajorService;
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
public class ZyyjMajorServiceImpl extends ServiceImpl<ZyyjMajorDao, ZyyjMajorPo> implements ZyyjMajorService {
    @Autowired
    ZyyjMajorDao majorDao;
    @Autowired
    ZyyjCollegeDao collegeDao;

    @Override
    public List<MajorVo> ConditionQuery(Integer collegeId) {
        LambdaQueryWrapper<ZyyjMajorPo> queryWrapper = new LambdaQueryWrapper<>();
        if (collegeId != null && collegeId != 0){
            queryWrapper.eq(ZyyjMajorPo::getCollegeId,collegeId);
        }
        List<ZyyjMajorPo> list = majorDao.selectList(queryWrapper);
        List<MajorVo> result_list = new ArrayList<>();
        for (ZyyjMajorPo majorPo:list){
            MajorVo majorVo = new MajorVo();
            BeanUtils.copyProperties(majorPo,majorVo);
            ZyyjCollegePo collegePo = collegeDao.selectById(majorPo.getCollegeId());
            if (collegePo != null){
                majorVo.setCollegeName(collegePo.getName());
            }
            result_list.add(majorVo);
        }
        return result_list;
    }

    @Override
    public PageInfo<MajorVo> getMajorByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MajorVo> majorVos = ConditionQuery(null);
        PageInfo<MajorVo> pageInfo = new PageInfo<>(majorVos);
        return pageInfo;
    }

    @Override
    public boolean insertMajor(ZyyjMajorPo majorPo){
        int count = majorDao.insert(majorPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMajor(ZyyjMajorPo majorPo) throws BusinessException {
        ZyyjMajorPo majorPo1 = majorDao.selectById(majorPo.getMajorId());
        if (majorPo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = majorDao.updateById(majorPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteMajor(Integer[] majorIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i <= majorIds.length; i++){
            ZyyjMajorPo majorPo = majorDao.selectById(majorIds[i]);
            if (majorPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += majorDao.deleteById(majorIds[i]);
        }
        if (count != majorIds.length){
            return false;
        }
        return true;
    }
}
