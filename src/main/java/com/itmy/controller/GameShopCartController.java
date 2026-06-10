package com.itmy.controller;

import com.itmy.pojo.entity.GameShopCart;
import com.itmy.pojo.entity.Result;
import com.itmy.pojo.vo.GameVo;
import com.itmy.service.GameShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopCart")
public class GameShopCartController {
    @Autowired
    private GameShopCartService gameShopCartService;

    //将游戏添加到购物车中
    @PostMapping("/add")
    public Result addshopCart(@RequestBody GameVo gameVo) {
        gameShopCartService.addshopCart(gameVo);
        return Result.success();
    }

    //查询购物车中的游戏
    @PostMapping("/query")
    public Result queryshopCart() {
        //查询购物车中的游戏
        List<GameShopCart> gameShopCartList = gameShopCartService.queryshopCart();
        return Result.success(gameShopCartList);
    }

    //删除购物车中的游戏
    @DeleteMapping("/delete")
    public Result deleteShopCart(@RequestParam Integer[] ids) {
        gameShopCartService.deleteShopCart(ids);
        return Result.success();
    }
}
