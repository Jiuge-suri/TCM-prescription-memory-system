package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.CollegeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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
public interface ZyyjCollegeDao extends BaseMapper<ZyyjCollegePo> {
    public Page<CollegeVo> getCollegeByPage(@Param("collegeId") Integer collegeId);
}
