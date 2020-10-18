package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStudentExamPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.StudentExamVo;
import io.swagger.models.auth.In;

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
    public Page<StudentExamVo> getStudentExamByPage(Integer pageNum, Integer pageSize,String account, String name,
                                                    Integer majorId, Integer gradeId, Integer classId, Integer courseId,Integer collegeId);

}
