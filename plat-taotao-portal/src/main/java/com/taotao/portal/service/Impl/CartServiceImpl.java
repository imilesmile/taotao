package com.taotao.portal.service.Impl;

import com.common.pojo.CartItem;
import com.common.pojo.TaotaoResult;
import com.common.utils.CookieUtils;
import com.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.portal.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HM on 16/12/29.
 */

@Service
public class CartServiceImpl implements CartService {




    @Override
    public TaotaoResult addCart(long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {

        List<CartItem> itemlist = getCartItemList(request);

        //如果有货物
        boolean haveFlag = false;

        for (CartItem cartItem : itemlist) {
            if (cartItem.getId() == itemId) {
                cartItem.setNum(cartItem.getNum() + num);
                haveFlag = true;
                break;
            }
        }

        if (!haveFlag){
            // TODO: 16/12/29 需要修改
            TbItem item = null;

            CartItem cartItem = new CartItem();
            cartItem.setId(itemId);
            cartItem.setNum(num);
            if (StringUtils.isNotBlank(item.getImage())){
                String image = item.getImage();
                String[] strings = image.split(",");
                cartItem.setImage(strings[0]);
            }
            cartItem.setTitle(item.getTitle());

            itemlist.add(cartItem);

        }

        String cookieValue = "";

        CookieUtils.setCookie(request, response, "TT_cart", JsonUtils.objectToJson(itemlist),500,true);

        return TaotaoResult.ok();
    }

    private List<CartItem> getCartItemList(HttpServletRequest request) {

        try {
            String json = CookieUtils.getCookieValue(request, "TT_cart", true);

            List<CartItem> list = JsonUtils.jsonToList(json, CartItem.class);

            return list == null ? new ArrayList<CartItem>() : list;
        } catch (Exception e) {
            return new ArrayList<CartItem>();
        }
    }
}
