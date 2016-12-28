package com.taotao.controller;

import com.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by HM on 16/12/26.
 */

@Controller
public class itemCatController {

    @Autowired
    private ItemCat itemCat;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCat(@RequestParam(value = "id",defaultValue = "0") long parentId){

        List<EasyUITreeNode> list = itemCat.getItemCat(parentId);

        return list;
    }
}
