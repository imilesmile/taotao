package com.taotao.controller;

import com.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HM on 16/12/26.
 */

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult createItemParam(@PathVariable long cid){

        TaotaoResult result = itemParamService.getItemParamByCid(cid);

        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult saveItemParam(@PathVariable long cid,String paramData){

        TaotaoResult result = itemParamService.saveItemParam(cid,paramData);

        return result;
    }

}
