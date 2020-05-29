package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExamProgramPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ExamProgramVo;
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
public interface ZyyjExamProgramService extends IService<ZyyjExamProgramPo> {
    public List<ExamProgramVo> ConditionQuery(String name);

    public PageInfo<ExamProgramVo> selectByPage(Integer pageNum, Integer pageSize);

    public boolean insertExamProgram(ZyyjExamProgramPo examProgramPo);

    public boolean updateExamProgram(ZyyjExamProgramPo examProgramPo) throws BusinessException;

    public boolean deleteExamProgram(Integer[] examProgramIds) throws BusinessException;
}
