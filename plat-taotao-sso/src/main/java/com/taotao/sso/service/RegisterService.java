package com.taotao.sso.service;

import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * Created by HM on 16/12/28.
 */
public interface RegisterService {

    TaotaoResult checkData(String param, int type);
    TaotaoResult register(TbUser user);
}
