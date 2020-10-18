package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjExchangeintegralPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.ExchangeintegralVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Component
public interface ZyyjExchangeintegralDao extends BaseMapper<ZyyjExchangeintegralPo> {
    public Page<ExchangeintegralVo> getIntegralByPage(@Param("stuIdArr") Integer[] stuIdArr);
}
