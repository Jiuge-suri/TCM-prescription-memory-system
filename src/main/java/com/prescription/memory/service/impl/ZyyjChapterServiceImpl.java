package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjCourseDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjChapterPo;
import com.prescription.memory.dao.ZyyjChapterDao;
import com.prescription.memory.entity.po.ZyyjCoursePo;
import com.prescription.memory.entity.vo.ChapterVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjChapterService;
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
public class ZyyjChapterServiceImpl extends ServiceImpl<ZyyjChapterDao, ZyyjChapterPo> implements ZyyjChapterService {
    @Autowired
    ZyyjChapterDao chapterDao;
    @Autowired
    ZyyjCourseDao courseDao;


    @Override
    public Page<ChapterVo> getChapterByPage(Integer courseId, String name) {
        return chapterDao.getChapterByPage(courseId,name);
    }

    @Override
    public List<ZyyjChapterPo> getAll(Integer courseId) {
        LambdaQueryWrapper<ZyyjChapterPo> queryWrapper = new LambdaQueryWrapper<>();
        if (courseId != null && courseId != 0){
            queryWrapper.eq(ZyyjChapterPo::getCourseId,courseId);
        }
        List<ZyyjChapterPo> list = chapterDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public boolean insertChapter(ZyyjChapterPo chapterPo) {
        int count = chapterDao.insert(chapterPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateChapter(ZyyjChapterPo chapterPo) throws BusinessException {
        chapterDao.selectById(chapterPo.getChapterId());
        int count = chapterDao.updateById(chapterPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteChapter(Integer[] chapterIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < chapterIds.length; i++){
            ZyyjChapterPo chapterPo = chapterDao.selectById(chapterIds[i]);
            if (chapterPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += chapterDao.deleteById(chapterIds[i]);
        }

        if (count != chapterIds.length){
            return false;
        }
        return true;
    }
}
