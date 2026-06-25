package com.itmy.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameReviewDto {
    private Integer id;
    private Integer gameId;
    private String userName;
    private  Integer reviewType;
    private String review;
    private LocalDateTime updateTime;
}
