package com.taotao.controller;

import com.common.pojo.EasyUIDataGridResult;
import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemList;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HM on 16/12/26.
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemList itemList;


    @RequestMapping("/item/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String html = itemService.getItemParamHtml(itemId);
        model.addAttribute("html", html);
        return"itemparam";
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        EasyUIDataGridResult result = itemList.getItemList(page,rows);

        return result;
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult createItem(TbItem item, String desc,String itemParams){


        TaotaoResult result = itemService.createItem(item,desc,itemParams);

        return result;
    }

}
