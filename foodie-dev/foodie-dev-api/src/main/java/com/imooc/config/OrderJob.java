package com.imooc.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhangyoubao
 * @version 2020/9/7
 */
@Component
public class OrderJob {

    /**
     * 使用定时任务关闭超期未支付订单，会存在的弊端
     * 1、会有时间差，程序不严谨
     * 2、不支持集群
     * 3、会对数据库权标搜索，及其影响数据库性能
     *
     * 定时任务仅仅只适用于小型轻量级项目，传统项目
     *
     * 消息队列：MQ -> RabbitMQ, RocketMQ, Kafka, ZeroMQ...
     *      延时任务（队列）
     */

    @Scheduled(cron = "0/3 * * * * ?")
    public void autoCloseOrder() {
        System.out.println(System.currentTimeMillis());
    }
}
