package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjClassPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.ClassVo;
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
public interface ZyyjClassService extends IService<ZyyjClassPo> {
    List<ClassVo> ConditionQuery(Integer gradeId, Integer majorId);

    PageInfo<ClassVo> getClassByPage(Integer pageNum, Integer pageSize);

    boolean insertClass(ZyyjClassPo classPo);

    boolean updateClass(ZyyjClassPo classPo) throws BusinessException;

    boolean deleteClass(Integer[] classIds) throws BusinessException;

}
