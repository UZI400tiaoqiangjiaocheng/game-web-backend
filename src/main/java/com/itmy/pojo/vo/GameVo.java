package com.itmy.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class GameVo {
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
}
