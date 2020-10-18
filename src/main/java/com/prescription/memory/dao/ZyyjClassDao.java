package com.prescription.memory.dao;
import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjClassPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.ClassVo;
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
public interface ZyyjClassDao extends BaseMapper<ZyyjClassPo> {
    public Page<ClassVo> getClassByPage(@Param("gradeId") Integer gradeId);
}
