package com.gbai.config;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 10:56
 **/
public interface QueueConstants {
    /**
     * 消息交换
     */
    String MESSAGE_EXCHANGE = "message.direct.exchange";
    /**
     * 消息队列名称
     */
    String MESSAGE_QUEUE_NAME = "message.queue";
    /**
     * 消息路由键
     */
    String MESSAGE_ROUTE_KEY = "message.send";


}
