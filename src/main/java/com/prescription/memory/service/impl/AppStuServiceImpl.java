package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.prescription.memory.dao.*;
import com.prescription.memory.entity.po.*;
import com.prescription.memory.entity.stuVo.*;
import com.prescription.memory.service.AppStuService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/19
 */
@Service
public class AppStuServiceImpl implements AppStuService {
    @Autowired
    AppStuDao dao;
    @Autowired
    ZyyjExchangeintegralDao exchangeintegralDao;
    @Autowired
    ZyyjStuScoreDao stuScoreDao;
    @Autowired
    ZyyjExchangeruleDao ruleDao;
    @Autowired
    ZyyjCourseDao courseDao;
    @Autowired
    ZyyjCheckpointDao checkpointDao;
    @Autowired
    ZyyjStudentPracticeDao studentPracticeDao;
    @Autowired
    ZyyjQuestionRecordDao questionRecordDao;
    @Autowired
    ZyyjStudentExamDao studentExamDao;
    @Override
    public ReqScoreRank getScoreManageRank(Integer stuId) {
        ReqScoreRank stuScoreInfo = dao.getStuScoreInfo(stuId);
        List<RankInfo> rankInfos = dao.getBeforeThirty();
        stuScoreInfo.setRanklist(rankInfos);
        return stuScoreInfo;
    }

    @Override
    public ReqScoreExchange getScoreManageExchange(Integer stuId) {
        //查询该学生是否兑换过积分
        LambdaQueryWrapper<ZyyjExchangeintegralPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ZyyjExchangeintegralPo::getStuId,stuId);
        ZyyjExchangeintegralPo exchangeintegralPo = exchangeintegralDao.selectOne(queryWrapper);

        ReqScoreExchange scoreExchange = new ReqScoreExchange();
        //如果没有返回用户积分，兑换规则信息，否则返回兑换信息
        if (exchangeintegralPo == null){
            //获取学生积分
            int totalScore = CurrentIntegral(stuId);
            scoreExchange.setMyscore(totalScore);
            //获取对换规则,为有效的信息
            List<ZyyjExchangerulePo> rulePos = ruleDao.selectList(
                                                new LambdaQueryWrapper<ZyyjExchangerulePo>()
                                                .eq(ZyyjExchangerulePo::getStatus,1));
            List<ExchangeruleInfo> ruleInfos = new ArrayList<>();
            BeanUtils.copyProperties(rulePos,ruleInfos);
            scoreExchange.setRules(ruleInfos);
        }else{
            ExchangeintegralInfo exchangeintegralInfo = new ExchangeintegralInfo();
            BeanUtils.copyProperties(exchangeintegralPo,exchangeintegralInfo);
            scoreExchange.setCglist(exchangeintegralInfo);
        }
        return scoreExchange;
    }

    @Override
    public Integer  getScoreManageChange(Integer stuId, Integer ruleId) {
        LambdaQueryWrapper<ZyyjExchangeintegralPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ZyyjExchangeintegralPo::getStuId,stuId);
        ZyyjExchangeintegralPo exchangeintegralPo1 = exchangeintegralDao.selectOne(queryWrapper);
        if (exchangeintegralPo1 != null){
            return -1;
        }
        //更具ruleId查询出相应的兑换规则
        ZyyjExchangerulePo rulePo = ruleDao.selectById(ruleId);
        //查询出学生的积分
        int totalScore = CurrentIntegral(stuId);
        //判断积分是否够
        if (rulePo.getIntegral() > totalScore){
            return 0;
        }
        //往积分兑换表中插入兑换记录
        ZyyjExchangeintegralPo exchangeintegralPo = new ZyyjExchangeintegralPo();
        exchangeintegralPo.setRuleId(ruleId);
        exchangeintegralPo.setStuId(stuId);
        exchangeintegralPo.setCreatedate(new Date());
        exchangeintegralPo.setScore(rulePo.getScore());
        exchangeintegralPo.setIntegral(rulePo.getIntegral());
        int count = exchangeintegralDao.insert(exchangeintegralPo);
        if (count != 1){
            return 2;
        }
        return 1;
    }
    @Override
    public ReqCheckPoint getCheckPointInfo(Integer stuId) {
       /*根据stuId查询该学生的通关记录，所到达的最高关卡*/
        Integer maxHavePassed = dao.havePassed(stuId);
        if (maxHavePassed == null){
            maxHavePassed = 0;
        }
        /*查询所有的关卡*/
        List<ZyyjCheckpointPo> checkpointPos = checkpointDao.selectList(null);
        ReqCheckPoint checkPoint = new ReqCheckPoint();
        checkPoint.setHavePassedId(maxHavePassed);
        checkPoint.setTotalCheckpoint(checkpointPos);

        return checkPoint;
    }
    @Override
    public List<Questions> getPracticeQuestion(Integer courseId, Integer checkpointId) {
        List<Questions> questions = dao.getPracitceQuestion(courseId, checkpointId);
        return questions;
    }

    @Override
    public boolean saveStudentPractice(ZyyjStudentPracticePo studentPracticePo) {
        int count = studentPracticeDao.insert(studentPracticePo);
        if (count != 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean saveQuestionRecord(List<ZyyjQuestionRecordPo> list) {
        for (ZyyjQuestionRecordPo questionRecordPo: list){
            int count = questionRecordDao.insert(questionRecordPo);
            if (count != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<ReqQuestionRecord> getQuestionRecord(Integer stuId, Integer courseId, Integer checkpointId) {
        List<ReqQuestionRecord> questionRecord = dao.getQuestionRecord(stuId, courseId, checkpointId);
        return questionRecord;
    }

    @Override
    public List<Questions> getExamQuestions(Integer courseId) {
        List<Questions> examQuestion = dao.getExamQuestion(courseId);
        return examQuestion;
    }

    @Override
    public ReqPersonInfo getPersonInfo(Integer stuId) {
        ReqPersonInfo personInfo = dao.getPersonInfo(stuId);
        return personInfo;
    }

    @Override
    public ZyyjStudentExamPo hasExamed(Integer stuId, Integer courseId) {
        ZyyjStudentExamPo studentExamPo = studentExamDao.selectOne(new LambdaQueryWrapper<ZyyjStudentExamPo>()
                .eq(ZyyjStudentExamPo::getCourseId, courseId)
                .eq(ZyyjStudentExamPo::getStuId, stuId));

        return studentExamPo;
    }

    @Override
    public boolean saveExamRecord(ZyyjStudentExamPo studentExamPo) {
        int count = studentExamDao.insert(studentExamPo);
        if (count != 1){
            return false;
        }
        return true;
    }

    @Override
    public List<ReqPracticeRecord> getPracticeRecord(Integer stuId) {
        List<ReqPracticeRecord> practiceRecord = dao.getPracticeRecord(stuId);
        return practiceRecord;
    }

    @Override
    public List<ReqExamRecord> getExamRecord(Integer stuId) {
        List<ReqExamRecord> examRecord = dao.getExamRecord(stuId);
        return examRecord;
    }

    //获得当前积分
    private int CurrentIntegral(Integer stuId){
        List<ZyyjStuScorePo> stuScorePos = stuScoreDao.selectList(new LambdaQueryWrapper<ZyyjStuScorePo>().eq(ZyyjStuScorePo::getStuId,stuId));
        int totalScore = 0;
        for (ZyyjStuScorePo stuScorePo: stuScorePos){
            totalScore += stuScorePo.getScore();
        }
        return  totalScore;
    }
}
