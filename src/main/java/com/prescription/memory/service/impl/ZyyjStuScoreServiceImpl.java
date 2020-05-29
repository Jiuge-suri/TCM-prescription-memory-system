package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    @Autowired
    ZyyjProgrammeDao programmeDao;

    @Override
    public List<StuScoreVo> getAll() {
        LambdaQueryWrapper<ZyyjStuScorePo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderBy(true,false,ZyyjStuScorePo::getScore);
        List<ZyyjStuScorePo> list = stuScoreDao.selectList(queryWrapper);
        List<StuScoreVo> result_List = new ArrayList<>();
        for (ZyyjStuScorePo stuScorePo: list){
            StuScoreVo stuScoreVo = new StuScoreVo();

            ZyyjStudentPo studentPo = studentDao.selectById(stuScorePo.getStuId());
            ZyyjProgrammePo programmePo = programmeDao.selectById(stuScorePo.getProgrammeId());

            BeanUtils.copyProperties(stuScorePo,stuScoreVo);

            if (programmePo != null){
                stuScoreVo.setProgrammeName(programmePo.getName());
            }
            if (studentPo != null){
                stuScoreVo.setStudentName(studentPo.getName());
            }
            result_List.add(stuScoreVo);
        }
        return result_List;

    }

    @Override
    public List<StuScoreVo> conditionQuery(String name, String account, Integer majorId, Integer gradeId, Integer classId) {
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
        //把查询出来的学生的stuId放入一个数组里面
        Integer[] stuIdArr = new Integer[1000];
        for (int i = 0; i < list.size(); i++){
            stuIdArr[i] = list.get(i).getStuId();
        }
        System.out.println(stuIdArr);
        //再次构造条件，跟据条件查询对应学生的闯关记录
        LambdaQueryWrapper<ZyyjStuScorePo> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.in(ZyyjStuScorePo::getStuId,stuIdArr).orderByDesc(ZyyjStuScorePo::getScore);
        List<ZyyjStuScorePo> stuScorePos = stuScoreDao.selectList(queryWrapper1);
        System.out.println(stuScorePos);
        //将po转换成相应的vo返回
        List<StuScoreVo> result_list = new ArrayList<>();
        for (ZyyjStuScorePo stuScorePo: stuScorePos){
            StuScoreVo stuScoreVo = new StuScoreVo();

            ZyyjProgrammePo programmePo = programmeDao.selectById(stuScorePo.getProgrammeId());

            ZyyjStudentPo stuPo = studentDao.selectById(stuScorePo.getStuId());
            BeanUtils.copyProperties(stuScorePo,stuScoreVo);

            if (stuPo != null){
                stuScoreVo.setStudentName(stuPo.getName());
            }
            if (programmePo != null){
                stuScoreVo.setProgrammeName(programmePo.getName());
            }
            result_list.add(stuScoreVo);
        }
        return result_list;
    }
    @Override
    public PageInfo<StuScoreVo> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StuScoreVo> list = getAll();
        PageInfo<StuScoreVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
