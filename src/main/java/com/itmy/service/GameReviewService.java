package com.itmy.service;

import com.itmy.pojo.dto.GameReviewDto;
import com.itmy.pojo.entity.GameReview;

import java.util.List;

public interface GameReviewService {
    void addReview(GameReviewDto gameReviewDto);

    List<GameReview> getReviewList(Integer gameId);

    void updateReview(GameReviewDto gameReviewDto);

    void deleteReview(Integer id);
}
