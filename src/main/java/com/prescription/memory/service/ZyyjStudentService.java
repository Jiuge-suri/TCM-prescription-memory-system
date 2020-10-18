package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.StudentVo;
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
public interface ZyyjStudentService extends IService<ZyyjStudentPo> {
    Page<StudentVo> getStudentByPage(Integer majorId, Integer gradeId, Integer classId, Integer sex, String account, String name, Integer collegeId);

    boolean insertStudent(ZyyjStudentPo stuPo);

    boolean updateStudent(ZyyjStudentPo stuPo) throws BusinessException;

    boolean deleteStudent(Integer[] stuIds) throws BusinessException;

}
