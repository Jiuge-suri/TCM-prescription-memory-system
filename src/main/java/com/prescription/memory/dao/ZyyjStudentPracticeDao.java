package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjStudentPracticePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.StudentPracticeVo;
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
public interface ZyyjStudentPracticeDao extends BaseMapper<ZyyjStudentPracticePo> {

    public Page<StudentPracticeVo> getStudentPracticeByPage(@Param("stuIdArr") Integer[] stuIdArr);
}
