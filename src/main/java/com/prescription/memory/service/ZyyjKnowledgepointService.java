package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjKnowledgepointPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.KnowledgepointVo;
import com.prescription.memory.error.BusinessException;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjKnowledgepointService extends IService<ZyyjKnowledgepointPo> {
    Page<KnowledgepointVo> getKnowledgepointByPage(Integer courseId, Integer chapterId, Integer requirId, String name);

    List<ZyyjKnowledgepointPo> getAll(Integer chapterId);

    boolean insertKnowledgepoint(ZyyjKnowledgepointPo knowlegepointPo);

    boolean updateKnowledgepoint(ZyyjKnowledgepointPo knowlegepointPo) throws BusinessException;

    boolean deleteKnowledgepoint(Integer[] knowlegepointIds) throws BusinessException;

}
