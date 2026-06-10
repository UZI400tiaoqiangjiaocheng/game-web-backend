package com.itmy.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameQueryParam {
    private String gameName;
    private Integer gameType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginYear;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endYear;
    private Integer gameSize;
    private Integer page;
    private Integer pageSize;
}
