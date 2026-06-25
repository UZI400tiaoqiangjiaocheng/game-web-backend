package com.itmy.controller;

import com.itmy.pojo.dto.UserLoginDto;
import com.itmy.pojo.entity.User;
import com.itmy.pojo.vo.LoginRequest;
import com.itmy.pojo.entity.Result;
import com.itmy.pojo.vo.UserVo;
import com.itmy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //获取用户信息
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestParam Integer id) {
        UserVo userVo = userService.getUserInfo(id);
        return Result.success(userVo);
    }

    //更新用户信息
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }
}
