package com.taotao.service;

import com.common.pojo.TaotaoResult;

/**
 * Created by HM on 16/12/26.
 */
public interface ItemParamService {

    TaotaoResult getItemParamByCid(long cid);

    TaotaoResult saveItemParam(long cid, String paramData);

}
