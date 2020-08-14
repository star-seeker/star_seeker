package com.imooc.enums;

/**
 * @author zhangyoubao
 * @version 2020/8/13
 * 支付方式枚举
 */
public enum PayMethod {

    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
