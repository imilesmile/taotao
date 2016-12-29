package com.taotao.portal.service.Impl;

import com.common.pojo.TaotaoResult;
import com.common.utils.CookieUtils;
import com.common.utils.HttpClientUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/29.
 */
public class UserServiceImpl implements UserService {

    @Override
    public TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response) {
        //从cookie取token
        String token = CookieUtils.getCookieValue(request, "TT_Token");
        //判断token是否有值
        if(StringUtils.isBlank(token)){
            return null;
        }


        //调用sso服务查询用户信息
        String json = HttpClientUtil.doGet(token);

        //将json转换成java对象
        TaotaoResult result = TaotaoResult.format(json);

        if (result.getStatus() != 200){
            return null;
        }

        //取用户对象
        result = TaotaoResult.formatToPojo(json, TbUser.class);
        TbUser user = (TbUser) result.getData();


        return user;
    }
}
