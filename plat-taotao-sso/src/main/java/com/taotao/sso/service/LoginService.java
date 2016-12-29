package com.taotao.sso.service;

import com.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/28.
 */
public interface LoginService {

    TaotaoResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);


}
