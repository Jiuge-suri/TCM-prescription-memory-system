package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamLevelPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ExamLevelVo;
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
public interface ZyyjExamLevelService extends IService<ZyyjExamLevelPo> {
    public Page<ExamLevelVo> getExamLevelByPage(Integer pageNum, Integer pageSize, String name);

    public List<ZyyjExamLevelPo> getAll();

    public boolean insertExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException;

    public boolean updateExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException;

    public boolean deleteExamLevel(Integer[] examLevelIds) throws BusinessException;

}
