package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.*;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.*;
import com.prescription.memory.entity.vo.StudentExamVo;
import com.prescription.memory.service.ZyyjStudentExamService;
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
 * @since 2020-05-25
 */
@Service
public class ZyyjStudentExamServiceImpl extends ServiceImpl<ZyyjStudentExamDao, ZyyjStudentExamPo> implements ZyyjStudentExamService {
    @Autowired
    ZyyjStudentExamDao studentExamDao;
    @Autowired
    ZyyjStudentDao studentDao;

    @Override
    public Page<StudentExamVo> getStudentExamByPage(Integer pageNum, Integer pageSize, String account,
                                                    String name, Integer majorId, Integer gradeId, Integer classId, Integer courseId, Integer collegeId) {
        List<ZyyjStudentPo> students = studentDao.ConditionQuery(account, name, majorId, gradeId, classId);
        System.out.println(students);
        Integer[] stuIdArr = new Integer[1000];
        for (int i = 0; i < students.size(); i++){
            stuIdArr[i] = students.get(i).getStuId();
        }
        PageHelper.startPage(pageNum,pageSize);
        return studentExamDao.getStudentExamByPage(stuIdArr);
    }
}
