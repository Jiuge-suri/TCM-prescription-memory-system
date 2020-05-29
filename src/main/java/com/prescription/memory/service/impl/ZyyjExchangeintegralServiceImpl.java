package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.prescription.memory.dao.ZyyjExchangeruleDao;
import com.prescription.memory.dao.ZyyjStudentDao;
import com.prescription.memory.entity.PageInfo;
import com.prescription.memory.entity.po.ZyyjExchangeintegralPo;
import com.prescription.memory.dao.ZyyjExchangeintegralDao;
import com.prescription.memory.entity.po.ZyyjExchangerulePo;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.vo.ExchangeintegralVo;
import com.prescription.memory.service.ZyyjExchangeintegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ZyyjExchangeintegralServiceImpl extends ServiceImpl<ZyyjExchangeintegralDao, ZyyjExchangeintegralPo> implements ZyyjExchangeintegralService {
    @Autowired
    ZyyjExchangeintegralDao exchangeintegralDao;
    @Autowired
    ZyyjExchangeruleDao exchangeruleDao;
    @Autowired
    ZyyjStudentDao studentDao;
    @Override
    public List<ExchangeintegralVo> getAll() {
        List<ZyyjExchangeintegralPo> list = exchangeintegralDao.selectList(null);
        List<ExchangeintegralVo> result_List = new ArrayList<>();
        for (ZyyjExchangeintegralPo exchangeintegralPo: list){
            ExchangeintegralVo exchangeintegralVo = new ExchangeintegralVo();

            ZyyjStudentPo studentPo = studentDao.selectById(exchangeintegralPo.getStuId());
            ZyyjExchangerulePo exchangerulePo = exchangeruleDao.selectById(exchangeintegralPo.getRuleId());

            BeanUtils.copyProperties(exchangeintegralPo,exchangeintegralVo);

            if (exchangerulePo != null){
                exchangeintegralVo.setRuleName(exchangerulePo.getName());
            }
            if (studentPo != null){
                exchangeintegralVo.setStudentName(studentPo.getName());
            }
            result_List.add(exchangeintegralVo);
        }
        return result_List;
    }

    @Override
    public List<List<ExchangeintegralVo>> conditionQuery(String name, String account, Integer majorId, Integer gradeId, Integer classId) {
        //构造条件，跟具条件查询所对应的学生
        LambdaQueryWrapper<ZyyjStudentPo> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null && name != ""){
            queryWrapper.like(ZyyjStudentPo::getName,name);
        }
        if (account != null && account != ""){
            queryWrapper.eq(ZyyjStudentPo::getAccount,account);
        }
        if (majorId != null && majorId != 0){
            queryWrapper.eq(ZyyjStudentPo::getMajorId,majorId);
        }
        if (gradeId != null && gradeId != 0){
            queryWrapper .eq(ZyyjStudentPo::getGradeId,gradeId);
        }
        if (classId != null && classId != 0){
            queryWrapper.eq(ZyyjStudentPo::getClassId,classId);
        }
        List<ZyyjStudentPo> list = studentDao.selectList(queryWrapper);
        System.out.println("查询出来的学生为："+list);
//更具条件查询对应学生的闯关记录
        List<List<ExchangeintegralVo>> result_list = new ArrayList<List<ExchangeintegralVo>>();
        for (ZyyjStudentPo stuPo: list){
            LambdaQueryWrapper<ZyyjExchangeintegralPo> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(ZyyjExchangeintegralPo::getStuId,stuPo.getStuId());
            List<ZyyjExchangeintegralPo> exchangeintegralPos = exchangeintegralDao.selectList(queryWrapper1);
            List<ExchangeintegralVo> exchangeintegralVos = new ArrayList<>();
            for (ZyyjExchangeintegralPo exchangeintegralPo: exchangeintegralPos){
                ExchangeintegralVo exchangeintegralVo = new ExchangeintegralVo();

                ZyyjExchangerulePo exchangerulePo = exchangeruleDao.selectById(exchangeintegralPo.getRuleId());

                BeanUtils.copyProperties(exchangeintegralPo,exchangeintegralVo);

                if (stuPo != null){
                    exchangeintegralVo.setStudentName(stuPo.getName());
                }
                if (exchangerulePo != null){
                    exchangeintegralVo.setRuleName(exchangerulePo.getName());
                }
                exchangeintegralVos.add(exchangeintegralVo);
            }
            result_list.add(exchangeintegralVos);
        }
        return result_list;
    }

    @Override
    public PageInfo<ExchangeintegralVo> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ExchangeintegralVo> list = getAll();
        PageInfo<ExchangeintegralVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
