package com.taotao.service.Impl;

import com.common.pojo.EasyUIDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HM on 16/12/26.
 */

@Service
public class ItemListImpl implements ItemList {

    /**
     *
     */
    @Autowired
    private TbItemMapper itemMapper;


    /**
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDataGridResult getItemList(final int page, final int rows) {

        //查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);

        //分页
        PageHelper.startPage(page, rows);

        PageInfo<TbItem> info = new PageInfo<>(list);

        EasyUIDataGridResult easyUI = new EasyUIDataGridResult();
        easyUI.setTotal(info.getTotal());
        easyUI.setRows(list);


        return easyUI;
    }
}
