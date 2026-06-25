package com.itmy.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameReview {
    private Integer id;
    private Integer userId;
    private Integer gameId;
    private String userName;
    private Integer reviewType;
    private String review;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
