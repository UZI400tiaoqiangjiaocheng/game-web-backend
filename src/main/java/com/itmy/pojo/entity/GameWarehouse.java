package com.itmy.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameWarehouse {
    private Integer id;
    private Integer UserId;
    private Integer gameId;
    private LocalDateTime createTime;
}
