package com.prescription.memory.service;

import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStudentExamPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.StudentExamVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-25
 */
public interface ZyyjStudentExamService extends IService<ZyyjStudentExamPo> {
    public List<StudentExamVo> ConditionQuery(String account, String name, Integer majorId, Integer gradeId, Integer classId, Integer courseId);
    public PageInfo<StudentExamVo> getExamRecordByPage(Integer pageNum, Integer pageSize);
}
