package com.prescription.memory.service;

import com.github.pagehelper.Page;
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
    Page<ClassVo> getClassByPage(Integer gradeId);

    List<ZyyjClassPo> getAll(Integer gradeId);

    boolean insertClass(ZyyjClassPo classPo);

    boolean updateClass(ZyyjClassPo classPo) throws BusinessException;

    boolean deleteClass(Integer[] classIds) throws BusinessException;

}
