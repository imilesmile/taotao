package com.taotao.service;

import com.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by HM on 16/12/26.
 */
public interface ItemCat {

    List<EasyUITreeNode> getItemCat(long parentId);
}
