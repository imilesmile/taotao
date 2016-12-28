package com.taotao.service.Impl;

import com.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.taotao.pojo.TbItemExample.Criteria;

/**
 * Created by HM on 16/12/26.
 */

@Service
public class itemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;


    @Override
    public TbItem getTbItemById(long itemId) {
        //1.查询
        TbItemExample example = new TbItemExample();
        Criteria criteria= example.createCriteria();
        criteria.andIdEqualTo(itemId);
        //2.执行查询
        List<TbItem> result = itemMapper.selectByExample(example);

        TbItem item = new TbItem();

        //3.返回结果
        if (result != null && result.size() > 0) {
            item = result.get(0);
        }

        return item;
    }

    @Override
    public TaotaoResult createItem(TbItem item, String desc, String itemParam) {
        return null;
    }

    @Override
    public String getItemParamHtml(Long itemId) {
        return null;
    }
}
