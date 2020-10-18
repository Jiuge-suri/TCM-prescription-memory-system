package com.prescription.memory.dao;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjQuestionPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prescription.memory.entity.vo.QuestionVo;
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
public interface ZyyjQuestionDao extends BaseMapper<ZyyjQuestionPo> {
    Page<QuestionVo> getQuestionByPage(@Param("courseId") Integer courseId,
                                       @Param("chapterId") Integer chapterId,
                                       @Param("knowId") Integer knowId,
                                       @Param("levelId") Integer levelId);
}
