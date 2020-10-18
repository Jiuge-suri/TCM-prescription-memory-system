package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjCoursePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.CourseTreeVo;
import com.prescription.memory.entity.vo.CourseVo;
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
public interface ZyyjCourseService extends IService<ZyyjCoursePo> {
    Page<CourseVo> getCourseByPage(String name);

    List<ZyyjCoursePo> getAll();

    boolean insertCourse(ZyyjCoursePo coursePo);

    boolean updateCourse(ZyyjCoursePo coursePo) throws BusinessException;

    boolean deleteCourse(Integer[] courseIds) throws BusinessException;

    List<CourseTreeVo> courseTreeList();

}
