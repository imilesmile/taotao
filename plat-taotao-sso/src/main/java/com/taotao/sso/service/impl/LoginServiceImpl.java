package com.taotao.sso.service.impl;

import com.common.pojo.TaotaoResult;
import com.common.utils.CookieUtils;
import com.common.utils.HttpClientUtil;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.sso.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Created by HM on 16/12/28.
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TbUserMapper userMapper;


    @Override
    public TaotaoResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        //校验用户名密码是否正确
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<TbUser> list = userMapper.selectByExample(example);

        if (list == null && list.isEmpty() ) {
            return TaotaoResult.build(400, "用户名或密码错误");
        }

        TbUser user = list.get(0);

        //校验密码
        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            return TaotaoResult.build(400, "用户名或密码错误");
        }
        //生成token
        String token = UUID.randomUUID().toString();
        //写入redis

        CookieUtils.setCookie(request,response,"TT_TOKEN",token);


        return null;
    }


}
