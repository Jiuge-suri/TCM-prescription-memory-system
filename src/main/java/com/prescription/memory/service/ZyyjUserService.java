package com.prescription.memory.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.prescription.memory.entity.vo.CollegeVo;
import com.prescription.memory.entity.vo.UserVo;
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
public interface ZyyjUserService extends IService<ZyyjUserPo> {
    List<UserVo> ConditionQuery(String name, Integer departmentId);
    Page<UserVo> getUserByPage(String name, Integer departmentId);
    PageInfo<UserVo> selectByPage(Integer pageNum, Integer pageSize);

    boolean insertUser(ZyyjUserPo userPo) throws BusinessException;

    boolean updateUser(ZyyjUserPo userPo) throws BusinessException;

    boolean deleteUser(Integer[] userIds) throws BusinessException;
}
