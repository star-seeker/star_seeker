package com.imooc.controller;

import com.imooc.enums.PayMethod;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.service.OrderService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RestController
@RequestMapping("orders")
public class OrdersController extends BaseController {

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("create")
    public IMOOCJSONResult create(@RequestBody SubmitOrderBO submitOrderBO,
            HttpServletRequest request, HttpServletResponse response) {

        if (!PayMethod.WEIXIN.type.equals(submitOrderBO.getPayMethod())
                && !PayMethod.ALIPAY.type.equals(submitOrderBO.getPayMethod())) {
            return IMOOCJSONResult.errorMsg("支付方式不支持");
        }

        // 1. 创建订单
        String orderId = orderService.createOrder(submitOrderBO);

        // 2. 创建订单后移除购物车中已结算的商品
        // TODO 整合redis后，完善购物车中的已结算商品清楚，并且同步到前端的cookie
        // CookieUtils.setCookie(request, response, FOODIE_SHOPCART, "", true);

        // 3. 向支付中心发送当前订单，用于保存支付中心的订单数据

        return IMOOCJSONResult.ok(orderId);
    }


}
