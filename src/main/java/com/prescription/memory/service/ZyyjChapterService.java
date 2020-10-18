package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjChapterPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ChapterVo;
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
public interface ZyyjChapterService extends IService<ZyyjChapterPo> {
    Page<ChapterVo> getChapterByPage(Integer courseId, String name);

    List<ZyyjChapterPo> getAll(Integer courseId);

    boolean insertChapter(ZyyjChapterPo chapterPo);

    boolean updateChapter(ZyyjChapterPo chapterPo) throws BusinessException;

    boolean deleteChapter(Integer[] chapterIds) throws BusinessException;
}
