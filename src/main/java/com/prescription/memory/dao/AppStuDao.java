package com.prescription.memory.dao;

import com.prescription.memory.entity.stuVo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Yinjie on 2020/5/21
 */
@Component
public interface AppStuDao {
    //获取学生科目的练习关卡
    public List<ReqPointRecord> getPointData(Integer stuId);
    //获取当前用户的积分信息
    public ReqScoreRank getStuScoreInfo(Integer stuId);
    //获取前三十名排名情况
    public List<RankInfo> getBeforeThirty();
    //查询该学生所到达的最大关卡
    public Integer havePassed(@Param("stuId") Integer stuId);
    //获取题目信息
    public List<Questions> getPracitceQuestion(@Param("courseId") Integer courseId,
                                       @Param("checkpointId") Integer checkpointId);
    //获取考试题目信息
    public List<Questions> getExamQuestion(@Param("courseId") Integer courseId);
    //获取学生的个人信息
    public ReqPersonInfo getPersonInfo(@Param("stuId") Integer stuId);
    //获取题目记录信息
    public List<ReqQuestionRecord> getQuestionRecord(@Param("stuId") Integer stuId, @Param("courseId") Integer courseId, @Param("checkpointId") Integer checkpointId);
    //查询考试记录
    public List<ReqExamRecord> getExamRecord(@Param("stuId") Integer stuId);
    //查询练习记录
    public List<ReqPracticeRecord> getPracticeRecord(@Param("stuId") Integer stuId);
}
