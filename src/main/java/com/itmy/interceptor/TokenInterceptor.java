package com.itmy.interceptor;

import com.itmy.utils.CurrentHolder;
import com.itmy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求路径
        String requestURI = request.getRequestURI();

        //判断请求路径是否包含/login
        if(requestURI.contains("/login") || requestURI.contains("/register")){
            log.info("请求路径包含/login，放行");
            return true;
        }

        //获取请求头中的token
        String token = request.getHeader("token");

        //判断token是否为空
        if(token == null || token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return false;
        }

        //如果token不为空校验令牌是否有效
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer id = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(id);
            log.info("当前登录员工的id为{}", id);
        } catch (Exception e) {
            log.error("令牌校验失败，响应401", e);
            response.setStatus(401);
            return false;
        }

        //如果验通过，放行
        return true;
    }
}
