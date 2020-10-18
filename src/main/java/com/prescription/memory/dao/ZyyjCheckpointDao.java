package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjCheckpointPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.CheckpointVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Component
public interface ZyyjCheckpointDao extends BaseMapper<ZyyjCheckpointPo> {
    public Page<CheckpointVo> getCheckpointByPage(@Param("name") String name);
}
