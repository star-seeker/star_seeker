package com.imooc.service;

import com.imooc.pojo.bo.SubmitOrderBO;

/**
 * @author zhangyoubao
 * @version 2020/8/13
 */
public interface OrderService {

    /**
     * 用于创建订单相关
     */
    String createOrder(SubmitOrderBO submitOrderBO);
}
