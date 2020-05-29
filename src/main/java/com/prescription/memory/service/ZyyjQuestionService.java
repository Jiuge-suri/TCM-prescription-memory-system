package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjQuestionPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.QuestionVo;
import com.prescription.memory.error.BusinessException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjQuestionService extends IService<ZyyjQuestionPo> {
    List<QuestionVo> ConditionQuery(Integer courseId,Integer chapterId,Integer knowId,Integer levelId);

    PageInfo<QuestionVo> getQuestionByPage(Integer pageNum, Integer pageSize);

    boolean insertQuestion(ZyyjQuestionPo questionPo);

    boolean updateQuestion(ZyyjQuestionPo questionPo) throws BusinessException;

    boolean deleteQuestion(Integer[] questionIds) throws BusinessException;

}
