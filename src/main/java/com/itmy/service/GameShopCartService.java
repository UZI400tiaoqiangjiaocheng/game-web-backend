package com.itmy.service;

import com.itmy.pojo.entity.GameShopCart;
import com.itmy.pojo.vo.GameVo;

import java.util.List;

public interface GameShopCartService {
    //将游戏添加到购物车中
    void addshopCart(GameVo gameVo);

    //查询购物车中的游戏
    List<GameShopCart> queryshopCart();

    //删除购物车中的游戏
    void deleteShopCart(Integer[] ids);
}
