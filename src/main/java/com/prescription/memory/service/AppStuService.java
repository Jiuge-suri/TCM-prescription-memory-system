package com.prescription.memory.service;

import com.prescription.memory.entity.po.ZyyjQuestionRecordPo;
import com.prescription.memory.entity.po.ZyyjStudentExamPo;
import com.prescription.memory.entity.po.ZyyjStudentPracticePo;
import com.prescription.memory.entity.stuVo.*;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
public interface AppStuService {
    //获取当前用户的积分情况何排名前三十的信息
    public ReqScoreRank getScoreManageRank(Integer stuId);
    //积分兑换前的反馈信息
    public ReqScoreExchange getScoreManageExchange(Integer stuId);
    //兑换积分，一千积分兑换0.5个学分
    public Integer getScoreManageChange(Integer stuId,Integer ruleId);
    //练习关卡
    public ReqCheckPoint getCheckPointInfo(Integer stuId);
    //获取题目信息
    public List<Questions> getPracticeQuestion(Integer courseId, Integer checkpointId);
    //保存练习记录
    public boolean saveStudentPractice(ZyyjStudentPracticePo studentPracticePo);
    //保存题目记录
    public boolean saveQuestionRecord(List<ZyyjQuestionRecordPo> list);
    //查询该学生相应科目对应的关卡下的做题记录
    public List<ReqQuestionRecord> getQuestionRecord(Integer stuId, Integer courseId, Integer checkpointId);
    //获取考试题目,从题库里面随机获取该科目下的20道题
    public List<Questions> getExamQuestions(Integer courseId);
    //查询学生的个人信息
    public ReqPersonInfo getPersonInfo(Integer stuId);
    //判断是否已经考试了
    public ZyyjStudentExamPo hasExamed(Integer stuId, Integer courseId);
    //保存考试记录
    public boolean saveExamRecord(ZyyjStudentExamPo studentExamPo);
    //查看练习记录
    public List<ReqPracticeRecord> getPracticeRecord(Integer stuId);
    //查看考试记录
    public List<ReqExamRecord> getExamRecord(Integer stuId);
}
