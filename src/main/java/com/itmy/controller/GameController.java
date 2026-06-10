package com.itmy.controller;

import com.itmy.mapper.UserMapper;
import com.itmy.pojo.dto.GameDto;
import com.itmy.pojo.dto.GameQueryParam;
import com.itmy.pojo.entity.Result;
import com.itmy.pojo.entity.User;
import com.itmy.pojo.vo.GameVo;
import com.itmy.service.GameService;
import com.itmy.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@Slf4j
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private UserMapper userMapper;

    //发行游戏
    @PostMapping("/gameLaunch")
    public Result gameLaunch(@RequestBody GameDto gameDto) {
        log.info("发行游戏:{}", gameDto);
        //获取当前用户id
        Integer currentId = CurrentHolder.getCurrentId();
        //通过用户id查询用户信息
        User user = userMapper.selectById(currentId);
        //判断该用户是否为企业用户
        if (user.getUserType() == 1){
            gameService.gameLaunch(gameDto);
            return Result.success();
        }
        return Result.error("您不是企业用户，不能发行游戏");
    }

    //查询游戏列表
    @GetMapping("/gameList")
    public Result gameList(GameQueryParam gameQueryParam) {
        gameService.selectGame(gameQueryParam);
        return Result.success(gameService.selectGame(gameQueryParam));
    }

    //通过id查询游戏详情
    @GetMapping("/gameDetail")
    public Result gameDetail(@RequestParam Integer gameId) {
        GameVo gameVo = gameService.selectGameById(gameId);
        return Result.success(gameVo);
    }
}
