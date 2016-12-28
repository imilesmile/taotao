package com.taotao.service;

import com.common.pojo.EasyUIDataGridResult;

/**
 * Created by HM on 16/12/26.
 */
public interface ItemList {

    EasyUIDataGridResult getItemList(int page, int rows);
}
