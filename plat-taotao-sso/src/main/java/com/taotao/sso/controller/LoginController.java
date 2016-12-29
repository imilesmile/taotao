package com.taotao.sso.controller;

import com.common.pojo.TaotaoResult;
import com.common.utils.ExceptionUtil;
import com.taotao.sso.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/28.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(String username, String passwd, HttpServletRequest request, HttpServletResponse response){

        try {
            TaotaoResult result = loginService.login(username, passwd, request, response);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return  TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/user/token/{token}", method = RequestMethod.POST)
    @ResponseBody
    public Object loginByToken(@PathVariable String token, String callback){

        try {
            TaotaoResult result = null;

            if (StringUtils.isNotBlank(callback)){
                MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            }



            return result;
        }catch (Exception e){
            e.printStackTrace();
            return  TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping("/page/login")
    public String showLogin(String redirectURL, Model model){
        //需要把参数传递给jsp
        model.addAttribute("redirect", redirectURL);
        return "login";
    }

    @RequestMapping("/page/register")
    public String showRegister(){
        return "register";
    }


}
