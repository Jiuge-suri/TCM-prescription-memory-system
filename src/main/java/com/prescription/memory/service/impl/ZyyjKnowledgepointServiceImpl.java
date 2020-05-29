package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjChapterDao;
import com.prescription.memory.dao.ZyyjCourseDao;
import com.prescription.memory.dao.ZyyjRequireDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjChapterPo;
import com.prescription.memory.entity.po.ZyyjCoursePo;
import com.prescription.memory.entity.po.ZyyjKnowledgepointPo;
import com.prescription.memory.dao.ZyyjKnowledgepointDao;
import com.prescription.memory.entity.po.ZyyjRequirePo;
import com.prescription.memory.entity.vo.KnowledgepointVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjKnowledgepointService;
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
public class ZyyjKnowledgepointServiceImpl extends ServiceImpl<ZyyjKnowledgepointDao, ZyyjKnowledgepointPo> implements ZyyjKnowledgepointService {
    @Autowired
    ZyyjKnowledgepointDao knowledgepointDao;
    @Autowired
    ZyyjRequireDao requireDao;
    @Autowired
    ZyyjCourseDao courseDao;
    @Autowired
    ZyyjChapterDao chapterDao;

    @Override
    public List<KnowledgepointVo> ConditionQuery(Integer courseId,Integer chapterId, Integer requirId, String name) {
        LambdaQueryWrapper<ZyyjKnowledgepointPo> queryWrapper = new LambdaQueryWrapper<>();
        if (courseId != null && courseId != 0){
            queryWrapper.eq(ZyyjKnowledgepointPo::getCourseId,chapterId);
        }
        if (chapterId != null && chapterId != 0){
            queryWrapper.eq(ZyyjKnowledgepointPo::getChapterId,chapterId);
        }
        if (requirId != null && requirId != 0){
            queryWrapper.eq(ZyyjKnowledgepointPo::getRequireId,requirId);
        }
        if (name != null && name != ""){
            queryWrapper.like(ZyyjKnowledgepointPo::getName,name);
        }
        List<ZyyjKnowledgepointPo> knowledgepointPos = knowledgepointDao.selectList(queryWrapper);
        List<KnowledgepointVo> result_list = new ArrayList<>();
        for (ZyyjKnowledgepointPo knowledgepointPo:knowledgepointPos){
            KnowledgepointVo knowledgepointVo = new KnowledgepointVo();
            ZyyjRequirePo requirePo = requireDao.selectById(knowledgepointPo.getRequireId());
            ZyyjCoursePo coursePo = courseDao.selectById(knowledgepointPo.getCourseId());
            ZyyjChapterPo chapterPo = chapterDao.selectById(knowledgepointPo.getChapterId());
            BeanUtils.copyProperties(knowledgepointPo,knowledgepointVo);
            if (requirePo != null){
                knowledgepointVo.setRequireName(requirePo.getName());
            }
            if (coursePo != null){
                knowledgepointVo.setCourseName(coursePo.getName());
            }
            if (chapterPo != null){
                knowledgepointVo.setChapterName(chapterPo.getName());
            }
            result_list.add(knowledgepointVo);
        }
        return result_list;
    }

    @Override
    public PageInfo<KnowledgepointVo> getKnowledgepointByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<KnowledgepointVo> list = ConditionQuery(null,null,null,null);
        PageInfo<KnowledgepointVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean insertKnowledgepoint(ZyyjKnowledgepointPo knowledgepointPo) {
        int count = knowledgepointDao.insert(knowledgepointPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateKnowledgepoint(ZyyjKnowledgepointPo knowledgepointPo) throws BusinessException {
        ZyyjChapterPo chapterPo = chapterDao.selectById(knowledgepointPo.getKnowId());
        if (chapterPo == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = knowledgepointDao.updateById(knowledgepointPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteKnowledgepoint(Integer[] knowledgepointIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < knowledgepointIds.length; i++){
            ZyyjKnowledgepointPo knowledgepointPo = knowledgepointDao.selectById(knowledgepointIds[i]);
            if (knowledgepointPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += knowledgepointDao.deleteById(knowledgepointIds[i]);
        }
        if (count != knowledgepointIds.length){
            return false;
        }
        return true;
    }
}
