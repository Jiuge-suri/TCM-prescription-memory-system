package com.prescription.memory.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.prescription.memory.entity.po.ZyyjUserPo;
import com.prescription.memory.error.BusinessException;
import com.prescription.memory.error.EmBusinessError;
import com.prescription.memory.jwt.JWTService;
import com.prescription.memory.service.ZyyjUserService;
import com.prescription.memory.utils.CommonreturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
//import sun.awt.EmbeddedFrame;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yinjie on 2020/5/10
 */
@RestController
@Api(tags = "登录模块")
public class LoginController extends BaseController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private ZyyjUserService zyyjUserService;

    @ApiIgnore
    @GetMapping("/toLogin")
    public CommonreturnType toLogin() throws BusinessException {
        throw new BusinessException(EmBusinessError.LOGINOUTTIME);
    }


    @ApiOperation("登录")
    @PostMapping("/login")
    public CommonreturnType login(@ApiParam(value = "用户名") @RequestParam(value = "username") String username,
                                  @ApiParam(value = "密码") @RequestParam(value = "password") String password,
                                  @ApiParam(value = "职位id") @RequestParam(value = "postId") Integer postId,
                                  HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new BusinessException(EmBusinessError.USER_Login_Fail);
        }
        ZyyjUserPo userInfo = zyyjUserService.
                getOne(Wrappers.<ZyyjUserPo>lambdaQuery().
                        eq(ZyyjUserPo::getName, username).
                        eq(ZyyjUserPo::getPassword, password).
                        eq(ZyyjUserPo::getPostId,postId));
        System.out.println(userInfo);
        if (userInfo == null) {
            throw new BusinessException(EmBusinessError.USER_Login_Fail);
        }

        Map<String, String> user = new HashMap<String, String>() {
            {
                put("name", userInfo.getName());
            }
        };

        String token = jwtService.createToken(user, 1);
        ServletContext context = request.getServletContext();
        context.setAttribute(token, token);
        System.out.println("token为："+token);
        return CommonreturnType.create(token);
    }
    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public CommonreturnType logout(String token, HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        context.removeAttribute(token);
        return CommonreturnType.create("logout");
    }
}