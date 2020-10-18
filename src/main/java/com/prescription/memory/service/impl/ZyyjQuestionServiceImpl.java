package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.*;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.*;
import com.prescription.memory.entity.vo.QuestionVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Service
public class ZyyjQuestionServiceImpl extends ServiceImpl<ZyyjQuestionDao, ZyyjQuestionPo> implements ZyyjQuestionService {
    @Autowired
    ZyyjQuestionDao questionDao;


    @Override
    public Page<QuestionVo> getQuestionByPage(Integer courseId, Integer chapterId, Integer knowId, Integer levelId) {
        return questionDao.getQuestionByPage(courseId,chapterId,knowId,levelId);
    }

    @Override
    public boolean insertQuestion(ZyyjQuestionPo questionPo) {
        int count = questionDao.insert(questionPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateQuestion(ZyyjQuestionPo questionPo) throws BusinessException {
        ZyyjQuestionPo questionPo1 = questionDao.selectById(questionPo.getQuestionId());
        if (questionPo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = questionDao.updateById(questionPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteQuestion(Integer[] questionIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < questionIds.length; i++){
            ZyyjQuestionPo questionPo = questionDao.selectById(questionIds[i]);
            if (questionPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += questionDao.deleteById(questionIds[i]);
        }
        if (count != questionIds.length){
            return false;
        }
        return true;
    }
}
