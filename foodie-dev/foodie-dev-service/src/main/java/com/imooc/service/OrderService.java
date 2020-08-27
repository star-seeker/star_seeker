package com.imooc.service;

import com.imooc.pojo.OrderStatus;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.pojo.vo.OrderVO;

/**
 * @author zhangyoubao
 * @version 2020/8/13
 */
public interface OrderService {

    /**
     * 用于创建订单相关
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 更新订单状态
     */
    void updateOrderStatus(String orderId, Integer orderStatus);

    OrderStatus queryOrderStatusInfo(String orderId);
}
