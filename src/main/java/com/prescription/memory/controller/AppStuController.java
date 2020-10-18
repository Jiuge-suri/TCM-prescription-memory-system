package com.prescription.memory.controller;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjQuestionRecordPo;
import com.prescription.memory.entity.po.ZyyjStudentExamPo;
import com.prescription.memory.entity.po.ZyyjStudentPracticePo;
import com.prescription.memory.entity.stuVo.*;
import com.prescription.memory.entity.vo.CourseTreeVo;
import com.prescription.memory.service.AppStuService;
import com.prescription.memory.service.ZyyjCourseService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@RestController
@Api(tags = "学生端与服务端数据交互接口")
public class AppStuController extends BaseController{
    @Autowired
    AppStuService stuService;
    @Autowired
    ZyyjCourseService courseService;

    @ApiOperation(value = "积分管理--积分排行榜")
    @PostMapping("/ScoreManage/ScoreManage_Rank")
    public CommonreturnType getScoreManageRank(@ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId){
        return CommonreturnType.create(stuService.getScoreManageRank(stuId));
    }
    @ApiOperation(value = "积分管理--积分兑换对应的反馈数据")
    @PostMapping("/ScoreManage/ScoreManage_exchange")
    public CommonreturnType getScoreManageExchange(@ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId){
        ReqScoreExchange exchange = stuService.getScoreManageExchange(stuId);
        if (exchange.getCglist() != null){
            return CommonreturnType.create(exchange,"您已兑换过学分",0);
        }
        return CommonreturnType.create(exchange,"还没有兑换过学分",1);
    }
    @ApiOperation(value = "积分管理--用户点击兑换响应")
    @PostMapping("/ScoreManage/ScoreManage_change")
    public CommonreturnType getScoreManageChange(@ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId,
                                                 @ApiParam(value="兑换规则id") @RequestParam(value = "ruleId")Integer ruleId){
        Integer count = stuService.getScoreManageChange(stuId, ruleId);
        if (count == 2){
            return CommonreturnType.create("","兑换失败，请重试",2);
        }else if (count == 0){
            return  CommonreturnType.create("","积分不足，兑换失败",0);
        }else if (count == -1){
            return  CommonreturnType.create("","您已兑换过积分",-1);
        }
        return CommonreturnType.create("","兑换成功",1);
    }
    @ApiOperation(value = "积分管理--个人积分记录")
    @PostMapping("/ScoreManage/ScoreManage_Myscore")
    public CommonreturnType getScoreManageMyscore(@ApiParam(value = "页数") @RequestParam(value = "pageNum") Integer pageNum,
            @ApiParam(value = "每页的数据大小") @RequestParam(value = "pageSize") Integer pageSize,
            @ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId){
        Page<IntegralRecord> page = stuService.getIntegralRecode(pageNum, pageSize, stuId);
        PageInfo<IntegralRecord> pageInfo = new PageInfo<>(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "科目管理--获取科目树")
    @PostMapping("/Course/get_all_nochield_courses")
    public CommonreturnType getAllCourses(){
        List<CourseTreeVo> courseTreeVos = courseService.courseTreeList();
        return CommonreturnType.create(courseTreeVos);
    }
    @ApiOperation(value = "练习管理--练习关卡信息读取")
    @PostMapping("/PracticeManage/PracticeManage_CheckpointInfo")
    public CommonreturnType getCheckPointInfo(@ApiParam(value = "学生Id") @RequestParam(value = "stuId") Integer stuId){
        ReqCheckPoint checkPointInfo = stuService.getCheckPointInfo(stuId);
        if (checkPointInfo.getHavePassedId() == 0){
            return CommonreturnType.create(checkPointInfo,"该学生暂未闯关",0);
        }
        return CommonreturnType.create(checkPointInfo,"获取成功",1);
    }
    @ApiOperation(value = "练习管理--保存练习记录")
    @PostMapping("/PointRecord/save_pointRecord")
    public CommonreturnType savePracticeRecord(@RequestBody ZyyjStudentPracticePo studentPracticePo){
        boolean result = stuService.saveStudentPractice(studentPracticePo);
        if (!result){
            return CommonreturnType.create("","失败",0);
        }
        return CommonreturnType.create("","成功",1);
    }
    @ApiOperation(value = "练习管理--题目信息")
    @PostMapping("/QuestionInterface/get_question")
    public CommonreturnType getQuestion(@ApiParam(value = "科目id") @RequestParam(value = "courseId") Integer courseId,
                                        @ApiParam(value = "获取关卡id或者考试id") @RequestParam(value = "checkpointId") Integer checkpointId){
        return CommonreturnType.create(stuService.getPracticeQuestion(courseId,checkpointId));
    }
    @ApiOperation(value = "练习管理--获取关卡题目历史记录")
    @PostMapping("/QuestionRecord/get_questionRecord")
    public CommonreturnType getQuestionRecord(@ApiParam(value = "科目id") @RequestParam(value = "courseId") Integer courseId,
                                              @ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId,
                                              @ApiParam(value = "关卡id") @RequestParam(value = "checkpointId")Integer checkpointId){
        List<ReqQuestionRecord> questionRecord = stuService.getQuestionRecord(stuId, courseId, checkpointId);
        if (questionRecord == null){
            return CommonreturnType.create(questionRecord,"获取失败，无记录",0);
        }
        return CommonreturnType.create(questionRecord,"获取成功",1);
    }
    @ApiOperation(value = "练习管理--保存做题信息")
    @PostMapping("/QuestionRecord/save_QuestionRecord")
    public CommonreturnType saveQuestionRecord(@RequestBody List<ZyyjQuestionRecordPo> list){
        System.out.println(list);
        boolean result = stuService.saveQuestionRecord(list);
        if (!result){
            return CommonreturnType.create("","失败",0);
        }
        return CommonreturnType.create("","成功",1);
    }
    @ApiOperation(value = "练习管理--查看练习记录")
    @PostMapping("/QuestionRecord/get_QuestionRecord")
    public CommonreturnType getPracticeRecord(@RequestParam(value = "stuId") Integer stuId){
        List<ReqPracticeRecord> practiceRecord = stuService.getPracticeRecord(stuId);
        return CommonreturnType.create(practiceRecord);
    }
    @ApiOperation(value = "考试管理--判断是否已经考了该科目")
    @PostMapping("/ExamManager/judge_hasExamed")
    public CommonreturnType hasExamed(@Param(value = "学生id") @RequestParam(value = "stuId") Integer stuId,
                                      @Param(value = "科目id") @RequestParam(value = "courId") Integer courseId){
        ZyyjStudentExamPo studentExamPo = stuService.hasExamed(stuId, courseId);
        if (studentExamPo != null){
            return CommonreturnType.create(studentExamPo,"不能重复考试",0);
        }
        return CommonreturnType.create(studentExamPo,"您还未考试",1);
    }
    @ApiOperation(value = "考试管理--获取考试题目")
    @PostMapping("/ExamManager/ExamManager_CheckpointInfo")
    public CommonreturnType getExamQuestions(@ApiParam(value = "课程Id") @RequestParam(value = "courseId") Integer courseId){
        List<Questions> examQuestions = stuService.getExamQuestions(courseId);
        return CommonreturnType.create(examQuestions);
    }
    @ApiOperation(value = "考试管理--保存考试记录")
    @PostMapping("/ExamManager/save_examRecord")
    public CommonreturnType saveExamRecord(@RequestBody ZyyjStudentExamPo studentExamPo){
        boolean result = stuService.saveExamRecord(studentExamPo);
        if (!result){
            return CommonreturnType.create("","保存失败",0);
        }
        return CommonreturnType.create("","保存成功",1);
    }
    @ApiOperation(value = "考试管理--查看考试记录")
    @PostMapping("/ExamManager/get_examRecord")
    public CommonreturnType getExamRecord(@RequestParam(value = "stuId") Integer stuId){
        List<ReqExamRecord> examRecord = stuService.getExamRecord(stuId);
        return CommonreturnType.create(examRecord);
    }
    @ApiOperation(value = "学生个人信息管理--学生个人信息")
    @PostMapping("/StudentInterface/stu_getPersonInfo")
    public CommonreturnType getPersonInfo(@ApiParam(value = "学生id") @RequestParam(value = "stuId") Integer stuId){
        ReqPersonInfo personInfo = stuService.getPersonInfo(stuId);
        if (personInfo == null){
            return CommonreturnType.create(personInfo,"没有查到该学生的信息",0);
        }
        return CommonreturnType.create(personInfo,"查询成功",1);
    }
    @ApiOperation(value = "学生个人信息管理--学生头像上传")
    @PostMapping("/StudentUpdateIcon/do_upload")
    public CommonreturnType doUploead(@ApiParam("新头像") @RequestParam("photo") String photo,
            @ApiParam(value = "学生Id") @RequestParam(value = "stuId") Integer stuId){

        return CommonreturnType.create(stuService.changePhoto(stuId,photo));
    }
}