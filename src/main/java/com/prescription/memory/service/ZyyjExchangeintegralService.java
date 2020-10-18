package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExchangeintegralPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ExchangeintegralVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjExchangeintegralService extends IService<ZyyjExchangeintegralPo> {

    public Page<ExchangeintegralVo> getIntegralByPage(Integer pageNum, Integer pageSize, String name, String account,
                                                      Integer majorId, Integer gradeId, Integer classId, Integer collegeId);


}
