package com.itmy.service.impl;

import com.itmy.mapper.UserMapper;
import com.itmy.pojo.dto.UserLoginDto;
import com.itmy.pojo.vo.LoginRequest;
import com.itmy.pojo.entity.User;
import com.itmy.service.UserService;
import com.itmy.utils.JwtUtils;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    @Override
    public LoginRequest userLogin(UserLoginDto userLoginDto) {
        User user = userMapper.selectBy(userLoginDto);
        if (user != null) {
            log.info("登录成功,用户id:{}", user.getId());

            //生成Jwt令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("account",user.getAccount());

            String JwtToken = JwtUtils.generateJwt(claims);
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setId(user.getId());
            loginRequest.setAccount(user.getAccount());
            loginRequest.setPassword(user.getPassword());
            loginRequest.setToken(JwtToken);
            return loginRequest;
        }
        return null;
    }

    //用户注册
    @Override
    public void register(User user) {
        //查询密码和账号是否重复
        UserLoginDto userLoginDto = new UserLoginDto();
        BeanUtils.copyProperties(user,userLoginDto);
        User user1 = userMapper.selectBy(userLoginDto);
        if (user1 != null) {
            throw new DuplicateRequestException("账号或密码已存在");
        }
        userMapper.insert(user);
    }
}
