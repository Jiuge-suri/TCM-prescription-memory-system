package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExchangerulePo;
import com.prescription.memory.dao.ZyyjExchangeruleDao;
import com.prescription.memory.entity.vo.ExchangeruleVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjExchangeruleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class ZyyjExchangeruleServiceImpl extends ServiceImpl<ZyyjExchangeruleDao, ZyyjExchangerulePo> implements ZyyjExchangeruleService {
    @Autowired
    private ZyyjExchangeruleDao ruledao;


    @Override
    public Page<ZyyjExchangerulePo> getExchangeruleByPage(String name) {
        return ruledao.getExchangeruleByPage(name);
    }

    @Override
    public List<ZyyjExchangerulePo> getAll() {
        return ruledao.selectList(null);
    }

    @Override
    public boolean insertExchangerule(ZyyjExchangerulePo rulePo) {
        int count = ruledao.insert(rulePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateExchangerule(ZyyjExchangerulePo rulePo) throws BusinessException {
        ZyyjExchangerulePo po = ruledao.selectById(rulePo.getRuleId());
        if (po == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = ruledao.updateById(rulePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteExchangerule(Integer[] ruleIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < ruleIds.length; i++){
            ZyyjExchangerulePo po = ruledao.selectById(ruleIds[i]);
            if (po == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += ruledao.deleteById(ruleIds[i]);
        }
        if (count != ruleIds.length){
            return false;
        }
        return true;
    }
}
