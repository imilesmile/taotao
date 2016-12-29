package com.taotao.portal;

import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/29.
 */
public class LoginInterceptor implements HandlerInterceptor{

    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //拦截请求url
        //从cookie中取token
        //如果没有token跳转到登录页面
        //取到token,需要调用sso系统的服务查询用户信息
        TbUser user = userService.getUserByToken(request,response);
        //如果用户session已经过期,跳转到登录页面
        if (user == null) {
            response.sendRedirect("");
            return false;
        }

        //如果没有过期,放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
