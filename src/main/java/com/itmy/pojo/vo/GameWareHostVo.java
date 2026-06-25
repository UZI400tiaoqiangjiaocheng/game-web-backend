package com.itmy.pojo.vo;

import lombok.Data;

@Data
public class GameWareHostVo {
    private Integer id;
    private Integer gameId;
    private Integer userId;
    private String gameName;
    private Double gameSize;
    private String gameCover;
    private String gameDownloadLink;
    private String gameExtractCode;
}
