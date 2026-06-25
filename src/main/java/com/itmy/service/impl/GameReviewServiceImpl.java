package com.itmy.service.impl;

import com.itmy.mapper.GameReviewMapper;
import com.itmy.pojo.dto.GameReviewDto;
import com.itmy.pojo.entity.GameReview;
import com.itmy.service.GameReviewService;
import com.itmy.utils.CurrentHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameReviewServiceImpl implements GameReviewService {
    @Autowired
    private GameReviewMapper gameReviewMapper;

    //添加评论
    @Override
    public void addReview(GameReviewDto gameReviewDto) {
        GameReview gameReview = new GameReview();
        //将gameReviewDto里的数据赋值给gameReview
        BeanUtils.copyProperties(gameReviewDto, gameReview);
        //设置userid
        gameReview.setUserId(CurrentHolder.getCurrentId());
        //设置创建时间和更新时间
        gameReview.setCreateTime(LocalDateTime.now());
        gameReview.setUpdateTime(LocalDateTime.now());

        gameReviewMapper.insert(gameReview);
    }

    //获取评论列表
    @Override
    public List<GameReview> getReviewList(Integer gameId) {
        List<GameReview> gameReviewList = gameReviewMapper.selectByGameId(gameId);
        return gameReviewList;
    }

    //修改评论
    @Override
    public void updateReview(GameReviewDto gameReviewDto) {
        GameReview gameReview = new GameReview();
        BeanUtils.copyProperties(gameReviewDto, gameReview);
        gameReview.setUpdateTime(LocalDateTime.now());
        gameReviewMapper.update(gameReview);
    }

    //删除评论
    @Override
    public void deleteReview(Integer id) {
        gameReviewMapper.deleteById(id);
    }
}
