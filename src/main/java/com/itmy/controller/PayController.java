package com.itmy.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PayController {
    public static String out_trade_no;

    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        out_trade_no = request.getParameter("out_trade_no");
        log.info("支付宝通知订单号: {}", out_trade_no);
        return "success";
    }
}
