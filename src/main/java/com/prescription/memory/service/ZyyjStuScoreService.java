package com.prescription.memory.service;

import com.github.pagehelper.Page;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjStuScorePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prescription.memory.entity.vo.StuScoreVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
public interface ZyyjStuScoreService extends IService<ZyyjStuScorePo> {

    public Page<StuScoreVo> getStuScoreRangeByPage(Integer pageSize, Integer pageNum, String name, String account, Integer majorId, Integer gradeId, Integer classId, Integer collegeId);
}
