package com.taotao.service.Impl;

import com.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HM on 16/12/26.
 */

@Service
public class ItemCatImpl implements ItemCat {

    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public List<EasyUITreeNode> getItemCat(final long parentId) {

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria= example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = itemCatMapper.selectByExample(example);

        List<EasyUITreeNode> nodeList = new ArrayList<>();

        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode treeNode = new EasyUITreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setText(tbItemCat.getName());
            treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
            nodeList.add(treeNode);

        }
        return nodeList;
    }
}
