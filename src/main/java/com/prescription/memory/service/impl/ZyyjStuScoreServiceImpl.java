package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjProgrammeDao;
import com.prescription.memory.dao.ZyyjStudentDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjProgrammePo;
import com.prescription.memory.entity.po.ZyyjStuScorePo;
import com.prescription.memory.dao.ZyyjStuScoreDao;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.vo.StuScoreVo;
import com.prescription.memory.service.ZyyjStuScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ZyyjStuScoreServiceImpl extends ServiceImpl<ZyyjStuScoreDao, ZyyjStuScorePo> implements ZyyjStuScoreService {
    @Autowired
    ZyyjStuScoreDao stuScoreDao;
    @Autowired
    ZyyjStudentDao studentDao;

    @Override
    public Page<StuScoreVo> getStuScoreRangeByPage(Integer pageNum, Integer pageSize, String name, String account, Integer majorId,
                                                   Integer gradeId, Integer classId, Integer collegeId) {
        //构造条件，跟据条件查询所对应的学生
        LambdaQueryWrapper<ZyyjStudentPo> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null && name != ""){
            queryWrapper.like(ZyyjStudentPo::getName,name);
        }
        if (account != null && account != ""){
            queryWrapper.eq(ZyyjStudentPo::getAccount,account);
        }
        if (majorId != null && majorId != 0){
            queryWrapper.eq(ZyyjStudentPo::getMajorId,majorId);
        }
        if (gradeId != null && gradeId != 0){
            queryWrapper .eq(ZyyjStudentPo::getGradeId,gradeId);
        }
        if (classId != null && classId != 0){
            queryWrapper.eq(ZyyjStudentPo::getClassId,classId);
        }
        if (collegeId != null && collegeId != 0){
            queryWrapper.eq(ZyyjStudentPo::getCollegeId,collegeId);
        }

        List<ZyyjStudentPo> list = studentDao.selectList(queryWrapper);
        System.out.println("查询出来的学生为："+list);
        //把查询出来的学生的stuId放入一个数组里面
        Integer[] stuIdArr = new Integer[1000];
        for (int i = 0; i < list.size(); i++){
            stuIdArr[i] = list.get(i).getStuId();
        }
        PageHelper.startPage(pageNum,pageSize);

        return stuScoreDao.getStuScoreRangeByPage(stuIdArr);
    }
}
