package com.imooc.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyoubao
 * @version 2020/8/10
 */
@RestController
public class BaseController {

    public static final int COMMENT_PAGE_SIZE = 10;

    public static final String FOODIE_SHOPCART = "shopcart";

    // 微信支付成功 -> 支付中心 -> 平台     回调通知的url
    String payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    // 支付中心调用地址
    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";
}
