package com.taotao.service.Impl;

import com.common.pojo.TaotaoResult;
import com.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.taotao.pojo.TbItemParamExample.Criteria;

/**
 * Created by HM on 16/12/26.
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public TaotaoResult getItemParamByCid(long cid) {

        TbItemParamExample example = new TbItemParamExample();
        Criteria criteria= example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size() > 0) {
            TbItemParam itemParam = list.get(0);
            return TaotaoResult.ok(itemParam);
        }

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult saveItemParam(long cid, String paramData) {

        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        Date date = new Date();
        itemParam.setUpdated(date);
        itemParam.setCreated(date);

        itemParamMapper.insert(itemParam);

        return TaotaoResult.ok();
    }

}
