package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjDepartmentDao;
import com.prescription.memory.dao.ZyyjPostDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjDepartmentPo;
import com.prescription.memory.entity.po.ZyyjPostPo;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.prescription.memory.dao.ZyyjUserDao;
import com.prescription.memory.entity.vo.UserVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Service
public class ZyyjUserServiceImpl extends ServiceImpl<ZyyjUserDao, ZyyjUserPo> implements ZyyjUserService {
    @Autowired
    ZyyjUserDao userDao;
    @Autowired
    ZyyjPostDao postDao;
    @Autowired
    ZyyjDepartmentDao departmentDao;

    @Override
    public List<UserVo> ConditionQuery(String name, Integer departmentId) {
        LambdaQueryWrapper<ZyyjUserPo> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null && name != ""){
            queryWrapper.like(ZyyjUserPo::getRealname,name);
        }
        if (departmentId != null && departmentId != 0){
            queryWrapper.eq(ZyyjUserPo::getDepartmentId,departmentId);
        }
        List<ZyyjUserPo> list = userDao.selectList(queryWrapper);
        List<UserVo> result_list = new ArrayList<>();
        for (ZyyjUserPo userPo: list){
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userPo,userVo);
            ZyyjPostPo postPo = postDao.selectById(userPo.getPostId());
            ZyyjDepartmentPo departmentPo = departmentDao.selectById(userPo.getDepartmentId());
            if (postPo != null){
                userVo.setPostName(postPo.getName());
            }
            if (departmentPo != null){
                userVo.setDepartmentName(departmentPo.getName());
            }
            result_list.add(userVo);
        }
        return result_list;
    }

    @Override
    public PageInfo<UserVo> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserVo> list = ConditionQuery(null,null);
        PageInfo<UserVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean insertUser(ZyyjUserPo userPo) throws BusinessException {
        int count = userDao.insert(userPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(ZyyjUserPo userPo) throws BusinessException {
        ZyyjUserPo userPo1 = userDao.selectById(userPo.getUserId());
        if (userPo1 == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        int count = userDao.updateById(userPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(Integer[] userIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < userIds.length; i++){
            ZyyjUserPo userPo = userDao.selectById(userIds[i]);
            if (userPo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += userDao.deleteById(userIds[i]);
        }
        if (count != userIds.length){
            return false;
        }
        return true;
    }
}
