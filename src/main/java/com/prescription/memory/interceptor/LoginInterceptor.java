package com.prescription.memory.interceptor;


import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.prescription.memory.jwt.JWTService;
import com.prescription.memory.jwt.Payload;
import com.prescription.memory.utils.ContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个HandlerInterceptor结课，再创建一个配置类实现WebMvcConfigure接口，重写addInterceptors方法
 * @author Yinjie
 * @create 2020/5/10
 * @since 1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 当前激活的配置文件
     */
    @Value("${spring.profiles.active}")
    private String env;


    private JWTService jwtService;

    public LoginInterceptor(JWTService jwtService) {
        this.jwtService = jwtService;
    }
    //编写拦截器校检逻辑
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("在请求处理之前进行调用Controller方法调用之前");
        //认证验证
        if ("dev".equals(env)) { //开发环境忽略签名认证
            return true;
        }

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String token = request.getHeader("X-Auth-Token");

        //token is null，判断是否携带凭证，若token为空，则跳转到登陆界面
        if (StringUtils.isEmpty(token)) {
            String url = "/toLogin";
            response.sendRedirect(url);
            return false;
        }

        String tokenInServletContext = (String)request.getServletContext().getAttribute(token);

        //未登录或者过期   ServletContext中找不到这个token
        if(StringUtils.isEmpty(tokenInServletContext)) {
            String url = "/toLogin";
            response.sendRedirect(url);
            return false;
        }

        try {
            //校验token，如果无误放行，若有误，则输出错误提示
            Payload payload = jwtService.verifyToken(token);
            ContextUtil.setCurrentUser(payload);//将payload存入threadLocal
        } catch (AlgorithmMismatchException e) {
            System.err.println("Token Checkout processing AlgorithmMismatchException 异常！"+e.getLocalizedMessage());
        }catch (TokenExpiredException e) {
            System.err.println("token已经过期");
        }catch (SignatureVerificationException e) {
            System.err.println("Token Checkout processing SignatureVerificationException 异常！"+e.getLocalizedMessage());
        }catch (Exception e) {
            System.err.println("Token Checkout processing 未知异常！"+e.getLocalizedMessage());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor...请求处理之后进行调用，但是在视图被渲染之前Controller方法调用之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("LoginInterceptor...在整个请求结束之后被调用，也就是DispacherServlet渲染了对应视图之后执行（主要是用于进行资源清理工作）");
    }
}