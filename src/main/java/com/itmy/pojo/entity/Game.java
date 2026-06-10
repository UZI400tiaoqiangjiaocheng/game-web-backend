package com.itmy.pojo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Game {
    private Integer id;
    private Integer userId;
    private String gameName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate gameYear;
    private Integer gameType;
    private String gameSize;
    private Double gamePrice;
    private String gameDescription;
    private String gameCover;
    private String gameDownloadLink;
    private String gameExtractCode;
    private Integer createUser;
    private Integer updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
