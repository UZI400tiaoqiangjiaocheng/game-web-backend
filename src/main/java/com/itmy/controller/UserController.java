package com.itmy.controller;

import com.itmy.pojo.dto.UserLoginDto;
import com.itmy.pojo.entity.User;
import com.itmy.pojo.vo.LoginRequest;
import com.itmy.pojo.entity.Result;
import com.itmy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDto userLoginDto) {
        LoginRequest loginRequest = userService.userLogin(userLoginDto);
        if (loginRequest != null) {
            return Result.success(loginRequest);
        }
        return Result.error("账号或密码错误");
    }

    //用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return Result.success();
    }
}
