package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    public List<ExchangeruleVo> ConditionQuery(String name) {
        LambdaQueryWrapper<ZyyjExchangerulePo> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null && name != ""){
            queryWrapper.like(ZyyjExchangerulePo::getName,name);
        }
        List<ZyyjExchangerulePo>  list = ruledao.selectList(queryWrapper);
        List<ExchangeruleVo>  result_list = new ArrayList<>();
        for (ZyyjExchangerulePo rulePo: list){
            ExchangeruleVo ruleVo = new ExchangeruleVo();
            BeanUtils.copyProperties(rulePo,ruleVo);
            result_list.add(ruleVo);
        }
        return result_list;
    }

     @Override
    public PageInfo<ExchangeruleVo> getExchangeruleByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ExchangeruleVo> list = ConditionQuery(null);
        PageInfo<ExchangeruleVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
