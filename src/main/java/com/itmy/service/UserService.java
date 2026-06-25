package com.itmy.service;

import com.itmy.pojo.dto.UserLoginDto;
import com.itmy.pojo.entity.User;
import com.itmy.pojo.vo.LoginRequest;
import com.itmy.pojo.vo.UserVo;


public interface UserService {
    //用户登录
    LoginRequest userLogin(UserLoginDto userLoginDto);

    //用户注册
    void register(User user);

    //获取用户信息
    UserVo getUserInfo(Integer id);

    //更新用户信息
    void update(User user);
}
