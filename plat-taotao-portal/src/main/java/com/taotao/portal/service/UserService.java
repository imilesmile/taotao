package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/29.
 */
public interface UserService {
    TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);
}
