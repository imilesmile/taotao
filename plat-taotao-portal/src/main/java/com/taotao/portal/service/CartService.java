package com.taotao.portal.service;

import com.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HM on 16/12/29.
 */
public interface CartService {
    TaotaoResult addCart(long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);
}
