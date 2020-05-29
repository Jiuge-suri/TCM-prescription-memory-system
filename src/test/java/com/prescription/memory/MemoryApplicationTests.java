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
import com.prescription.memory.service.AppStuService;
import com.prescription.memory.service.ZyyjDepartmentService;
import com.prescription.memory.service.ZyyjStudentExamService;
import com.prescription.memory.service.ZyyjStudentPracticeService;
import com.prescription.memory.service.impl.ZyyjDepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemoryApplicationTests {
    /*@Autowired
    ZyyjCollegeDao zyyjCollegeDao;
*/
    @Test
    void contextLoads() {
        System.out.println("测试成功");
    }
    /*@Test
    public void testSQL(){
        Page<CollegeVo> list = zyyjCollegeDao.getCollegeByPage();
        System.out.println(list);
    }*/
    /*@Test
    public void testS(){
        ZyyjCollegePo list = zyyjCollegeDao.selectBy();
        System.out.println(list);
    }*/
    @Autowired
    ZyyjDepartmentService departmentService = new ZyyjDepartmentServiceImpl();
    @Test
    public void testDeptTree(){
        List<DeptRespNodeVo> list = departmentService.deptTreeList();
        for (DeptRespNodeVo vo: list){
            System.out.println("顶层:"+vo.getName()+"子集："+vo.getChildren());
        }
    }
    @Autowired
    ZyyjStudentPracticeService service;
    @Test
    public void testStudentPractice(){
        String name="张三";
        List<List<StudentPracticeVo>> list = service.conditionQuery(name,null,null,null,null);
        System.out.println(list);
    }
    @Test
    public void testGetAll(){
        List<StudentPracticeVo> all = service.getAll();
        System.out.println("获得的结果为："+all);
    }
    @Autowired
    AppStuService stuService;
    @Test
    public void test(){
        ReqPersonInfo personInfo = stuService.getPersonInfo(1);
        System.out.println(personInfo);

    }
    @Autowired
    ZyyjStudentExamService studentExamService;
    @Test
    public void test1(){
        System.out.println(studentExamService.ConditionQuery(null,null,null,null,null,null));
    }
}
