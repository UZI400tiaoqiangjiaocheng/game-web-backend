package com.itmy.controller;

import com.itmy.pojo.dto.GameReviewDto;
import com.itmy.pojo.entity.GameReview;
import com.itmy.pojo.entity.Result;
import com.itmy.service.GameReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@Slf4j
public class GameReviewController {

    @Autowired
    private GameReviewService gameReviewService;

    // 添加游戏评论
    @PostMapping("/add")
    public Result addReview(@RequestBody GameReviewDto gameReviewDto) {
        gameReviewService.addReview(gameReviewDto);
        return Result.success();
    }

    // 获取游戏评论列表
    @GetMapping("/getReview")
    public Result getReviewList(@RequestParam Integer gameId) {
        List<GameReview> gameReviewList = gameReviewService.getReviewList(gameId);
        return Result.success(gameReviewList);
    }

    //修改游戏评论
    @PutMapping("/update")
    public Result updateReview(@RequestBody GameReviewDto gameReviewDto) {
        gameReviewService.updateReview(gameReviewDto);
        return Result.success();
    }

    //删除游戏评论
    @DeleteMapping("/delete")
    public Result deleteReview(@RequestParam Integer id) {
        gameReviewService.deleteReview(id);
        return Result.success();
    }
}
