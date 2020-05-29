package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.*;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.*;
import com.prescription.memory.entity.vo.StudentPracticeVo;
import com.prescription.memory.service.ZyyjStudentPracticeService;
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
public class ZyyjStudentPracticeServiceImpl extends ServiceImpl<ZyyjStudentPracticeDao, ZyyjStudentPracticePo> implements ZyyjStudentPracticeService {
    @Autowired
    private ZyyjStudentPracticeDao practiceDao;
    @Autowired
    private ZyyjStudentDao studentDao;
    @Autowired
    private ZyyjProgrammeDao programmeDao;
    @Autowired
    private ZyyjCourseDao courseDao;
    @Autowired
    private ZyyjCheckpointDao checkpointDao;
    @Override
    public List<StudentPracticeVo> getAll() {
        List<ZyyjStudentPracticePo> list = practiceDao.selectList(null);
        List<StudentPracticeVo> result_List = new ArrayList<>();
        for (ZyyjStudentPracticePo practicePo: list){
            StudentPracticeVo practiceVo = new StudentPracticeVo();

            ZyyjCheckpointPo checkpointPo = checkpointDao.selectById(practicePo.getCheckpointId());
            ZyyjProgrammePo programmePo = programmeDao.selectById(practicePo.getPracticeId());
            ZyyjCoursePo coursePo = courseDao.selectById(practicePo.getCourseId());
            ZyyjStudentPo stuPo = studentDao.selectById(practicePo.getStuId());

            BeanUtils.copyProperties(practicePo,practiceVo);

            if (stuPo != null){
                practiceVo.setStuName(stuPo.getName());
            }
            if (programmePo != null){
                practiceVo.setProgrammeName(programmePo.getName());
            }
            if (checkpointPo != null){
                practiceVo.setCheckpointName(checkpointPo.getName());
            }
            if (coursePo != null){
                practiceVo.setCourseName(coursePo.getName());
            }
            result_List.add(practiceVo);
        }
        return result_List;
    }

    @Override
    public List<List<StudentPracticeVo>> conditionQuery(String name,String account,Integer gradeId, Integer majorId, Integer classId) {
        //构造条件，跟具条件查询所对应的学生
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
        List<ZyyjStudentPo> list = studentDao.selectList(queryWrapper);
        System.out.println("查询出来的学生为："+list);
        //更具条件查询对应学生的闯关记录
        List<List<StudentPracticeVo>> result_list = new ArrayList<List<StudentPracticeVo>>();
        for (ZyyjStudentPo stuPo: list){
            LambdaQueryWrapper<ZyyjStudentPracticePo> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(ZyyjStudentPracticePo::getStuId,stuPo.getStuId());
            List<ZyyjStudentPracticePo> practicePos = practiceDao.selectList(queryWrapper1);
            List<StudentPracticeVo> practiceVos = new ArrayList<>();
            for (ZyyjStudentPracticePo practicePo: practicePos){
                StudentPracticeVo practiceVo = new StudentPracticeVo();

                ZyyjCheckpointPo checkpointPo = checkpointDao.selectById(practicePo.getCheckpointId());
                ZyyjProgrammePo programmePo = programmeDao.selectById(practicePo.getPracticeId());
                ZyyjCoursePo coursePo = courseDao.selectById(practicePo.getCourseId());

                BeanUtils.copyProperties(practicePo,practiceVo);

                if (stuPo != null){
                    practiceVo.setStuName(stuPo.getName());
                }
                if (programmePo != null){
                    practiceVo.setProgrammeName(programmePo.getName());
                }
                if (checkpointPo != null){
                    practiceVo.setCheckpointName(checkpointPo.getName());
                }
                if (coursePo != null){
                    practiceVo.setCourseName(coursePo.getName());
                }
                practiceVos.add(practiceVo);
            }
            result_list.add(practiceVos);
        }
        return result_list;
    }
    @Override
    public PageInfo<StudentPracticeVo> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentPracticeVo> list = getAll();
        PageInfo<StudentPracticeVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
