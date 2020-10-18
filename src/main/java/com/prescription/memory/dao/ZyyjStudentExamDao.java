package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjStudentExamPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.StudentExamVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-25
 */
@Component
public interface ZyyjStudentExamDao extends BaseMapper<ZyyjStudentExamPo> {
    public Page<StudentExamVo> getStudentExamByPage(@Param("stuIdArr") Integer[] stuIdArr);
}
