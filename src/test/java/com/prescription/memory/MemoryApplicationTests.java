package com.prescription.memory;

import com.github.pagehelper.Page;
import com.prescription.memory.dao.ZyyjCollegeDao;
import com.prescription.memory.entity.po.ZyyjCollegePo;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.stuVo.ReqPersonInfo;
import com.prescription.memory.entity.vo.CollegeVo;
import com.prescription.memory.entity.vo.DepartmentVo;
import com.prescription.memory.entity.vo.DeptRespNodeVo;
import com.prescription.memory.entity.vo.StudentPracticeVo;
import com.prescription.memory.service.*;
import com.prescription.memory.service.impl.ZyyjDepartmentServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemoryApplicationTests {
    @Autowired
    ZyyjDepartmentService service;
    @Autowired
    ZyyjGradeService gradeService;
    @Autowired
    ZyyjCourseService courseService;
    @Test
    public void test(){
        System.out.println(service.deptTreeList());
    }

    @Test
    public void test2(){
        System.out.println(gradeService.getAll(null));
    }

    @Test
    public void test3(){
        System.out.println(courseService.courseTreeList());
    }

}
