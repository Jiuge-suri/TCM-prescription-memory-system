package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjKnowledgepointPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.KnowledgepointVo;
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
public interface ZyyjKnowledgepointDao extends BaseMapper<ZyyjKnowledgepointPo> {
    public Page<KnowledgepointVo> getKnowledgepointByPage(@Param("courseId") Integer courseId,
                                                          @Param("chapterId") Integer chapterId,
                                                          @Param("requireId") Integer requirId,
                                                          @Param("name") String name);
}
