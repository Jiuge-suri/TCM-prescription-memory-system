package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExchangerulePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ExchangeruleVo;
import com.prescription.memory.error.BusinessException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjExchangeruleService extends IService<ZyyjExchangerulePo> {

    List<ExchangeruleVo> ConditionQuery(String name);

    PageInfo<ExchangeruleVo> getExchangeruleByPage(Integer pageNum, Integer pageSize);

    boolean insertExchangerule(ZyyjExchangerulePo rulePo);

    boolean updateExchangerule(ZyyjExchangerulePo rulePo) throws BusinessException;

    boolean deleteExchangerule(Integer[] ruleIds) throws BusinessException;


}
