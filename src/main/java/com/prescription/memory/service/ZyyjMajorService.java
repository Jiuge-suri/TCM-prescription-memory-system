package com.prescription.memory.service;

import com.github.pagehelper.Page;
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
    Page<MajorVo> getMajorByPage(Integer collegeId, Integer majorId);

    List<ZyyjMajorPo> getAll(Integer collegeId);

    boolean insertMajor(ZyyjMajorPo majorPo);

    boolean updateMajor(ZyyjMajorPo majorPo) throws BusinessException;

    boolean deleteMajor(Integer[] majorIds) throws BusinessException;


}
