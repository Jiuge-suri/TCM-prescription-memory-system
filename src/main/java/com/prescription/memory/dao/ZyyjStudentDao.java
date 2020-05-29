package com.prescription.memory.dao;

import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ZyyjStudentDao extends BaseMapper<ZyyjStudentPo> {
    public List<ZyyjStudentPo> ConditionQuery(@Param("account") String account,
                                               @Param("name") String name,
                                               @Param("majorId") Integer majorId,
                                               @Param("gradeId") Integer gradeId,
                                               @Param("classId") Integer classId);
}
