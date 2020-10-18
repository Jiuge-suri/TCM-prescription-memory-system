package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjExamProgramPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.ExamProgramVo;
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
public interface ZyyjExamProgramDao extends BaseMapper<ZyyjExamProgramPo> {
    public Page<ExamProgramVo> getExamProgrammeByPage(@Param("name") String name);
}
