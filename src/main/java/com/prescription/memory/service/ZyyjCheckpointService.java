package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.CheckpointVo;
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
public interface ZyyjCheckpointService extends IService<ZyyjCheckpointPo> {
    List<CheckpointVo> ConditionQuery(String name);

    PageInfo<CheckpointVo> getCheckpointByPage(Integer pageNum, Integer pageSize);

    boolean insertCheckpoint(ZyyjCheckpointPo checkpointPo);

    boolean updateCheckpoint(ZyyjCheckpointPo checkpointPo) throws BusinessException;

    boolean deleteCheckpoint(Integer[] checkpointIds) throws BusinessException;

}
