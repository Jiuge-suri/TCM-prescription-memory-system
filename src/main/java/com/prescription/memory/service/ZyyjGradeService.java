package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjGradePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.GradeVo;
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
public interface ZyyjGradeService extends IService<ZyyjGradePo> {

    List<GradeVo> ConditionQuery(Integer majorId);

    PageInfo<GradeVo> getGradeByPage(Integer pageNum, Integer pageSize);

    boolean insertGrade(ZyyjGradePo gradePo);

    boolean updateGrade(ZyyjGradePo gradePo) throws BusinessException;

    boolean deleteGrade(Integer[] gradeIds) throws BusinessException;

}
