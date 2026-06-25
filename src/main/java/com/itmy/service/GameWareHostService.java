package com.itmy.service;


import com.itmy.pojo.vo.GameWareHostVo;

import java.util.List;

public interface GameWareHostService {
    List<GameWareHostVo> queryGame(String gameName);

    void deleteGame(Integer id);
}
