package com.taotao.service;

import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by HM on 16/12/26.
 */

public interface ItemService {

    TbItem getTbItemById(long itemId);

    TaotaoResult createItem(TbItem item, String desc,String itemParam);

    String getItemParamHtml(Long itemId);

}
