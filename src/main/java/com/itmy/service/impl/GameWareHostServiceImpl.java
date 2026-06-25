package com.itmy.service.impl;

import com.itmy.mapper.GameWareHostMapper;
import com.itmy.pojo.vo.GameVo;
import com.itmy.pojo.vo.GameWareHostVo;
import com.itmy.service.GameWareHostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GameWareHostServiceImpl implements GameWareHostService {

    @Autowired
    private GameWareHostMapper gameWareHostMapper;

    //根据游戏名称查询游戏
    @Override
    public List<GameWareHostVo> queryGame(String gameName) {
        List<GameWareHostVo> gameVos = gameWareHostMapper.queryGame(gameName);
        return gameVos;
    }

    //删除游戏
    @Override
    public void deleteGame(Integer id) {
        gameWareHostMapper.deleteGame(id);
    }
}
