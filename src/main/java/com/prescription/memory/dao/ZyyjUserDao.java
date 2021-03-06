package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.UserVo;
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
public interface ZyyjUserDao extends BaseMapper<ZyyjUserPo> {
    public Page<UserVo> getUserByPage(@Param("name") String name, @Param("departmentId") Integer departmentId);
}
