package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    @Autowired
    ZyyjCourseDao courseDao;
    @Autowired
    ZyyjExamLevelDao examLevelDao;
    @Autowired
    ZyyjProgrammeDao programmeDao;

    @Override
    public List<StudentExamVo> ConditionQuery(String account, String name, Integer majorId, Integer gradeId, Integer classId, Integer courseId) {
        List<ZyyjStudentPo> students = studentDao.ConditionQuery(account, name, majorId, gradeId, classId);
        System.out.println(students);
        List<StudentExamVo> result_list = new ArrayList<>();
        List<ZyyjStudentExamPo> list = new ArrayList<>();
        for (ZyyjStudentPo studentPo: students){
            LambdaQueryWrapper<ZyyjStudentExamPo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ZyyjStudentExamPo::getStuId,studentPo.getStuId());
            if (courseId != null && courseId != 0){
                queryWrapper.eq(ZyyjStudentExamPo::getCourseId,courseId);
            }
            List<ZyyjStudentExamPo> examPos = studentExamDao.selectList(queryWrapper);
            for (ZyyjStudentExamPo examPo: examPos){
                StudentExamVo examVo = new StudentExamVo();
                BeanUtils.copyProperties(examPo,examVo);
                ZyyjCoursePo coursePo = courseDao.selectById(examPo.getCourseId());
                ZyyjExamLevelPo levelPo = examLevelDao.selectById(examPo.getLevelId());
                ZyyjProgrammePo programmePo = programmeDao.selectById(examPo.getProgrammeId());
                if (coursePo != null) {
                    examVo.setCourseName(coursePo.getName());
                }
                if (levelPo != null){
                    examVo.setLevelName(levelPo.getName());
                }
                if (programmePo != null){
                    examVo.setProgrammeName(programmePo.getName());
                }
                examVo.setStuName(studentPo.getName());
                if (examVo != null){
                    result_list.add(examVo);
                }
            }
        }
        return result_list;
    }

    @Override
    public PageInfo<StudentExamVo> getExamRecordByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentExamVo> examVos = ConditionQuery(null, null, null, null, null, null);
        PageInfo<StudentExamVo> pageInfo = new PageInfo<>(examVos);
        return pageInfo;
    }

}
