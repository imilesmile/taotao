package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HM on 16/12/26.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
