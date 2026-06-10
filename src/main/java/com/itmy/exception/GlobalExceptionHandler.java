package com.itmy.exception;

import com.itmy.pojo.entity.Result;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 1. 精确捕获你当前报错的异常
     */
    @ExceptionHandler(DuplicateRequestException.class)
    public Result handleDuplicateRequestException(DuplicateRequestException e) {
        log.error("捕获到重复请求异常: {}", e.getMessage());
        // 直接返回友好的提示信息
        return Result.error("账号或密码已存在");
    }

    /**
     * 2. 兜底异常处理器（强烈建议保留）
     * 捕获所有未被上面方法处理的未知异常，防止系统直接向前端暴露 500 错误堆栈
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统发生未知异常", e);
        return Result.error("服务器内部错误，请联系管理员");
    }
}
