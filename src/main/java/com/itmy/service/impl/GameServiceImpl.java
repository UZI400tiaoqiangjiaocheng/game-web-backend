package com.itmy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itmy.mapper.GameMapper;
import com.itmy.pojo.dto.GameDto;
import com.itmy.pojo.dto.GameQueryParam;
import com.itmy.pojo.entity.Game;
import com.itmy.pojo.vo.GameVo;
import com.itmy.pojo.vo.PageResult;
import com.itmy.service.GameService;
import com.itmy.utils.CurrentHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Override
    public void gameLaunch(GameDto gameDto) {
        Game game = new Game();
        BeanUtils.copyProperties(gameDto,game);
        //获取当前用户id
        Integer currentId = CurrentHolder.getCurrentId();
        game.setUserId(currentId);
        game.setCreateUser(currentId);
        game.setUpdateUser(currentId);
        game.setCreateTime(LocalDateTime.now());
        game.setUpdateTime(LocalDateTime.now());
        gameMapper.insert(game);
    }

    //分页查询游戏
    @Override
    public PageResult<GameVo> selectGame(GameQueryParam gameQueryParam) {
        //设置分页参数
        PageHelper.startPage(gameQueryParam.getPage(), gameQueryParam.getPageSize());

        //执行查询
        List<GameVo> gameVoList = gameMapper.list(gameQueryParam);

        //将数据封装到PageResult中
        Page<GameVo> p = (Page<GameVo>) gameVoList;
        return new PageResult<GameVo>(p.getTotal(), p.getResult());
    }

    @Override
    public GameVo selectGameById(Integer gameId) {
        GameVo gameVo = gameMapper.selectGameById(gameId);
        return gameVo;
    }
}
