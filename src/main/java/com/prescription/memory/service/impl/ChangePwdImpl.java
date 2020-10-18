package com.prescription.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.prescription.memory.contants.Contant;
import com.prescription.memory.dao.ZyyjStudentDao;
import com.prescription.memory.dao.ZyyjUserDao;
import com.prescription.memory.entity.ResetPwd;
import com.prescription.memory.entity.po.ZyyjStudentPo;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.service.ChangePwdService;
import com.prescription.memory.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yinjie on 2020/6/5
 */
@Service
public class ChangePwdImpl implements ChangePwdService {
    @Autowired
    RedisService redisService;
    @Autowired
    ZyyjStudentDao studentDao;
    @Autowired
    ZyyjUserDao userDao;
    @Override
    public String getCode(String phone) throws BusinessException {
        //验证手机号是否合法,正则表达式
        Pattern pattern = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()) {
            throw  new BusinessException(EmBusinessError.PHONE_TYPE);
        }
        //判断手机号是否超限
        long count = redisService.incrby(Contant.REGISTER_CODE_COUNT_KEY+phone,1);
        if(count>5){
            throw new BusinessException(EmBusinessError.CODE_NUM);
        }
        //生成6位随机数
        String code=generateCode();
        //存入 redis 过期时间为 5 分钟
        redisService.set(Contant.REGISTER_CODE_COUNT_VALIDITY_KEY+phone,code,5, TimeUnit.MINUTES);
        return code;
    }

    @Override
    public String changePwd(ResetPwd resetPwd) throws BusinessException {
        //判断验证码是否正确
        if (!redisService.hasKey(Contant.REGISTER_CODE_COUNT_VALIDITY_KEY+resetPwd.getPhone() )){
            throw new BusinessException(EmBusinessError.CODE_VALIDATE);
        }
        //校验验证码是否正确
        if(!resetPwd.getCode().equals(redisService.get(Contant.REGISTER_CODE_COUNT_VALIDITY_KEY+resetPwd.getPhone()))){
            throw new BusinessException(EmBusinessError.CODE_WRONG);
        }

        if (resetPwd.getPostId() == 4){
            ZyyjStudentPo studentPo1 = studentDao.selectOne(new LambdaQueryWrapper<ZyyjStudentPo>().eq(ZyyjStudentPo::getPhone, resetPwd.getPhone()));
            if(studentPo1 ==null){
                throw new BusinessException(EmBusinessError.ACCOUNT_WRONG);
            }
            ZyyjStudentPo  studentPo = studentDao.selectById(resetPwd.getId());
            studentPo.setPassword(resetPwd.getNewPwd());
            int count = studentDao.updateById(studentPo);
            if (count != 1){
                return "修改失败";
            }
        }else{
            ZyyjUserPo userPo1 = userDao.selectOne(new LambdaQueryWrapper<ZyyjUserPo>().eq(ZyyjUserPo::getPhone, resetPwd.getPhone()));
            if(userPo1 == null){
                throw new BusinessException(EmBusinessError.ACCOUNT_WRONG);
            }
            ZyyjUserPo userPo = userDao.selectById(resetPwd.getId());
            userPo.setPassword(resetPwd.getNewPwd());
            int count = userDao.updateById(userPo);
            if (count != 1){
                return "修改失败";
            }
        }
        return "修改成功";
    }
    /**
     * 生成六位验证码
     */
    private String generateCode(){
        Random random = new Random();
        int x = random.nextInt(899999)+100000;
        String code = String.valueOf(x);
        return code;
    }
}
