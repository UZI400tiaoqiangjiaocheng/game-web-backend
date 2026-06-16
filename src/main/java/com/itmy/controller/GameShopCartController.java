package com.itmy.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson.JSONObject;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.itmy.config.AlipayConfig;
import com.itmy.pojo.entity.GameShopCart;
import com.itmy.pojo.entity.Result;
import com.itmy.pojo.vo.GameVo;
import com.itmy.service.GameShopCartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/shopCart")
public class GameShopCartController {
    @Autowired
    private GameShopCartService gameShopCartService;
    @Autowired
    private Config config;

    //将游戏添加到购物车中
    @PostMapping("/add")
    public Result addshopCart(@RequestBody GameVo gameVo) {
        gameShopCartService.addshopCart(gameVo);
        return Result.success();
    }

    //查询购物车中的游戏
    @PostMapping("/query")
    public Result queryshopCart() {
        //查询购物车中的游戏
        List<GameShopCart> gameShopCartList = gameShopCartService.queryshopCart();
        return Result.success(gameShopCartList);
    }

    //删除购物车中的游戏
    @DeleteMapping("/delete")
    public Result deleteShopCart(@RequestParam Integer[] ids) {
        gameShopCartService.deleteShopCart(ids);
        return Result.success();
    }

    //购买游戏
    @GetMapping("/pay")
    public Result pay(@RequestParam Double price) throws Exception {
        try {
            // 1. 参数校验
            if (price == null || price <= 0) {
                return Result.error("支付金额不合法");
            }

            Factory.setOptions(config);
            String orderNo = UUID.randomUUID().toString();

            // 2. 将价格格式化为两位小数（解决支付宝金额格式报错）
            String formattedPrice = String.format("%.2f", price);

            // 3. 调用支付宝接口
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .preCreate("游戏购买", orderNo, formattedPrice);

            String qrCodeUrl = response.getQrCode();
            return Result.success(qrCodeUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统异常: " + e.getMessage());
        }
    }


    @GetMapping("/query")
    public Result queryPayStatus() throws Exception {
        Factory.setOptions(config);
        try {
            String orderNo = PayController.out_trade_no;
            AlipayTradeQueryResponse response = Factory.Payment.Common().query(orderNo);
            String tradeStatus = response.getTradeStatus();
            if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)) {
                return Result.success(1);
            }else if ("WAIT_BUYER_PAY".equals(tradeStatus)) {
                return Result.success(2);
            } else if ("TRADE_CLOSED".equals(tradeStatus)) {
                return Result.success(3);
            }
        }catch (Exception e){
            log.error("查询支付状态异常", e);
        }
        return Result.error("查询订单状态失败");
//        if (PayController.out_trade_no == null || PayController.out_trade_no.trim().isEmpty()) {
//            return Result.error("订单号不能为空");
//        }
//        return Result.success(1);
    }

    //将购买的游戏加入游戏库
    @GetMapping("/addGame")
    public Result addGame(@RequestParam Integer[] ids) {
        gameShopCartService.addGame(ids);
        return Result.success();
    }
}