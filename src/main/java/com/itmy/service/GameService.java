package com.itmy.service;

import com.itmy.pojo.dto.GameDto;
import com.itmy.pojo.dto.GameQueryParam;
import com.itmy.pojo.vo.GameVo;
import com.itmy.pojo.vo.PageResult;

public interface GameService {
    //发行游戏
    void gameLaunch(GameDto gameDto);

    //分页查询游戏
    PageResult<GameVo> selectGame(GameQueryParam gameQueryParam);

    //通过id查询游戏详情
    GameVo selectGameById(Integer gameId);
}
