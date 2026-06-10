package com.itmy.pojo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String account;
    private String phone;
    private String company;
    private Integer userType;
}
