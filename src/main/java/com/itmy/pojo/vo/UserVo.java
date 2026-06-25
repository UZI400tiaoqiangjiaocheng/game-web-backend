package com.itmy.pojo.vo;

import lombok.Data;

@Data
public class UserVo {
    private String username;
    private String password;
    private String account;
    private Integer userType;
    private Double totalAssets;
}
