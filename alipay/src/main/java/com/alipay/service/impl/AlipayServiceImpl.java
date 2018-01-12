package com.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.alipay.config.AlipayConfig;
import com.alipay.service.AlipayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * AlipayServiceImpl created with IntelliJ IDEA.
 * User: PengFei
 * Date: 2018-01-12
 * Time: 10:46
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Resource
    private AlipayConfig alipayConfig;

    @Resource
    private Gson gson;

    @Override
    public String toPay() {
        // 获得初始化的 alipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getAppId(), alipayConfig.getAppPrivateKey(), alipayConfig.getFormat(), alipayConfig.getCharset(), alipayConfig.getAlipayPublicKey(), alipayConfig.getSignType());
        // 创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 同步回调
        alipayRequest.setReturnUrl(alipayConfig.getReturnUrl());
        // 异步回调
        alipayRequest.setNotifyUrl(alipayConfig.getNotifyUrl());
        // 把请求参数打包成集合
        Map<String, String> param = new HashMap<>();
        param.put("out_trade_no", "P20171102132932653");
        param.put("product_code", alipayConfig.getProductCode());
        param.put("total_amount", "0.01");
        param.put("subject", "my order");
        String bizContent = gson.toJson(param);
        // 填充业务参数
        alipayRequest.setBizContent(bizContent);
        String form="";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}
