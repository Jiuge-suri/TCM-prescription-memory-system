package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjMajorPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.MajorVo;
import com.prescription.memory.error.BusinessException;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjMajorService extends IService<ZyyjMajorPo> {
    List<MajorVo> ConditionQuery(Integer collegeId);

    PageInfo<MajorVo> getMajorByPage(Integer pageNum, Integer pageSize);

    boolean insertMajor(ZyyjMajorPo majorPo);

    boolean updateMajor(ZyyjMajorPo majorPo) throws BusinessException;

    boolean deleteMajor(Integer[] majorIds) throws BusinessException;


}
