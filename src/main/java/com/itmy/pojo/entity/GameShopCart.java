package com.itmy.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class GameShopCart {
    private Integer id;
    private Integer buyUserId;
    private Integer gameId;
    private String gameName;
    private Double gamePrice;
    private String gameCover;
    private LocalDateTime createTime;

}
