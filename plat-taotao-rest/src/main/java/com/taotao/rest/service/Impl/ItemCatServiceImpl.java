package com.taotao.rest.service.Impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.taotao.pojo.TbItemCatExample.*;

/**
 * Created by HM on 16/12/27.
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public ItemCatResult getItemCatList() {




        return null;
    }

    private List getItemCatList(Long parentId) {

        List resultList = new ArrayList();

        //查询
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);

        for (TbItemCat tbItemCat : list) {
            CatNode catNode = new CatNode();

            if (tbItemCat.getIsParent()) {


            }else {

            }
        }

        return null;
    }


}
