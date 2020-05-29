package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamLevelPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ExamLevelVo;
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
public interface ZyyjExamLevelService extends IService<ZyyjExamLevelPo> {
    public List<ExamLevelVo> ConditionQuery(String name);

    public PageInfo<ExamLevelVo> selectByPage(Integer pageNum, Integer pageSize);

    public boolean insertExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException;

    public boolean updateExamLevel(ZyyjExamLevelPo examLevelPo) throws BusinessException;

    public boolean deleteExamLevel(Integer[] examLevelIds) throws BusinessException;

}
