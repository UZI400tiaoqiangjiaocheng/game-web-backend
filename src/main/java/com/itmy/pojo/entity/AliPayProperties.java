package com.itmy.pojo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "alipay.easy")
public class AliPayProperties {
    //请求协议
    private String protocol;
    //请求网关地址
    private String gatewayHost;
    //签名类型
    private String signType;
    //应用ID
    private String appId;
    //应用私钥
    private String merchantPrivateKey;
    //支付宝公钥
    private String alipayPublicKey;
    //通知URL
    private String notifyUrl;
    //设置AES加密密钥
    private String encryptKey;
}
