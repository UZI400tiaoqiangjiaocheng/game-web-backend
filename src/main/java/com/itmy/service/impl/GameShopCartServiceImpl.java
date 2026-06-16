package com.itmy.service.impl;

import com.itmy.mapper.GameShopCartMapper;
import com.itmy.pojo.entity.GameShopCart;
import com.itmy.pojo.entity.GameWarehouse;
import com.itmy.pojo.vo.GameVo;
import com.itmy.service.GameShopCartService;
import com.itmy.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GameShopCartServiceImpl implements GameShopCartService {

    @Autowired
    private GameShopCartMapper gameShopCartMapper;

    //将游戏添加到购物车中
    @Override
    public void addshopCart(GameVo gameVo) {
        log.info("将游戏添加到购物车中",gameVo);
        GameShopCart gameShopCart = new GameShopCart();
        BeanUtils.copyProperties(gameVo,gameShopCart);
        gameShopCart.setGameId(gameVo.getId());
        //获取当前用户id
        Integer currentUserId = CurrentHolder.getCurrentId();
        gameShopCart.setBuyUserId(currentUserId);
        gameShopCart.setCreateTime(LocalDateTime.now());
        gameShopCartMapper.insert(gameShopCart);
    }

    @Override
    public List<GameShopCart> queryshopCart() {
        //获取当前登录用户id
        Integer currentUserId = CurrentHolder.getCurrentId();
        //根据用户id查询购物车中的游戏
        List<GameShopCart> gameShopCartList = gameShopCartMapper.selectByBuyUserId(currentUserId);
        return gameShopCartList;
    }

    @Override
    public void deleteShopCart(Integer[] ids) {
        //根据id删除购物车中的游戏
        gameShopCartMapper.deleteBatchIds(List.of(ids));
    }

    //将游戏添加到游戏仓库中
    @Override
    public void addGame(Integer[] ids) {
        List<GameWarehouse> gameWarehouseList = new ArrayList<>();
        for (Integer id : ids) {
            GameWarehouse gameWarehouse = new GameWarehouse();
            gameWarehouse.setUserId(CurrentHolder.getCurrentId());
            gameWarehouse.setGameId(id);
            gameWarehouse.setCreateTime(LocalDateTime.now());
            gameWarehouseList.add(gameWarehouse);
        }
        gameShopCartMapper.insertGame(gameWarehouseList);
    }
}
