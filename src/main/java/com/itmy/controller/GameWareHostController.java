package com.itmy.controller;

import com.itmy.pojo.entity.Result;
import com.itmy.pojo.vo.GameWareHostVo;
import com.itmy.service.GameWareHostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameHost")
@Slf4j
public class GameWareHostController {
    @Autowired
    private GameWareHostService gameWareHostService;

    //根据游戏名称查询游戏
    @GetMapping("/query")
    public Result queryGame(@RequestParam String gameName) {
        System.out.println(gameName);
        List<GameWareHostVo> gameVos = gameWareHostService.queryGame(gameName);
        return Result.success(gameVos);
    }

    //删除游戏
    @DeleteMapping("/delete")
    public Result deleteGame(@RequestParam Integer id) {
        gameWareHostService.deleteGame(id);
        return Result.success();
    }
}
