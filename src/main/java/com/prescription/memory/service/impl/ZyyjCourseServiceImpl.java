package com.prescription.memory.service.impl;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.po.ZyyjCoursePo;
import com.prescription.memory.dao.ZyyjCourseDao;
import com.prescription.memory.entity.vo.CourseTreeChild;
import com.prescription.memory.entity.vo.CourseTreeVo;
import com.prescription.memory.entity.vo.CourseVo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ZyyjCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ZyyjCourseServiceImpl extends ServiceImpl<ZyyjCourseDao, ZyyjCoursePo> implements ZyyjCourseService {
    @Autowired
    ZyyjCourseDao courseDao;


    @Override
    public Page<CourseVo> getCourseByPage(String name) {
        return courseDao.getCourseByPage(name);
    }

    @Override
    public List<ZyyjCoursePo> getAll() {
        return courseDao.selectList(null);
    }

    @Override
    public boolean insertCourse(ZyyjCoursePo coursePo) {
        int count = courseDao.insert(coursePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCourse(ZyyjCoursePo coursePo) throws BusinessException {
        courseDao.selectById(coursePo.getCourseId());
        int count = courseDao.updateById(coursePo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCourse(Integer[] courseIds) throws BusinessException {
        int count = 0;
        for (int i = 0; i < courseIds.length; i++){
            ZyyjCoursePo coursePo = courseDao.selectById(courseIds[i]);
            if (coursePo == null){
                throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            }
            count += courseDao.deleteById(courseIds[i]);
        }

        if (count != courseIds.length){
            return false;
        }
        return true;
    }
    //获得科目树
    @Override
    public List<CourseTreeVo> courseTreeList() {
        List<ZyyjCoursePo> list = courseDao.selectList(null);
        CourseTreeVo courseTreeVo = new CourseTreeVo();
        courseTreeVo.setCourseId(0);
        courseTreeVo.setName("默认顶级科目");
        courseTreeVo.setChildren(getTree(list));
        List<CourseTreeVo> result = new ArrayList<>();
        result.add(courseTreeVo);
        return result;
    }
    private List<CourseTreeVo> getTree(List<ZyyjCoursePo> all){
        List<CourseTreeVo> list = new ArrayList<>();
        for (ZyyjCoursePo coursePo: all){
            if (coursePo.getParentId().equals(0)){
                CourseTreeVo courseTreeVo = new CourseTreeVo();
                BeanUtils.copyProperties(coursePo,courseTreeVo);
                courseTreeVo.setChildren(getChild(coursePo.getCourseId(),all));
                list.add(courseTreeVo);
            }
        }
        return list;
    }
    private List<CourseTreeChild> getChild(Integer id, List<ZyyjCoursePo> all){
        List<CourseTreeChild> list = new ArrayList<>();
        int flag = 1;
        for (ZyyjCoursePo coursePo:all){
            if (coursePo.getParentId().equals(id)){
                CourseTreeChild courseTreeChild = new CourseTreeChild();
                BeanUtils.copyProperties(coursePo,courseTreeChild);
                //courseTreeVo.setChildren(getChild(coursePo.getCourseId(),all));
                flag= 0;
                list.add(courseTreeChild);
            }
        }
        if (flag==1){
            CourseTreeChild courseTreeChild = new CourseTreeChild();
            ZyyjCoursePo coursePo = courseDao.selectById(id);
            BeanUtils.copyProperties(coursePo,courseTreeChild);
            list.add(courseTreeChild);
        }
        return list;
    }
}
