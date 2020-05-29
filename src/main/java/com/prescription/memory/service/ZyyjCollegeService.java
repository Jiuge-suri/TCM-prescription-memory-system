package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.entity.vo.CollegeVo;
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
public interface ZyyjCollegeService extends IService<ZyyjCollegePo> {

    List<CollegeVo> ConditionQuery(Integer collegeId);

    PageInfo<CollegeVo> getCollegeByPage(Integer pageNum, Integer pageSize);

    boolean insertCollege(ZyyjCollegePo collegePo) throws BusinessException;

    boolean updateCollege(ZyyjCollegePo collegePo) throws BusinessException;

    boolean deleteCollege(Integer[] collegeId) throws BusinessException;
}
