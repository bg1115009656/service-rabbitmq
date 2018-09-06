package com.gbai.rabbitmq;

import com.gbai.enums.ExchangeEnum;
import com.gbai.enums.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-08-03 14:23
 **/
public interface QueueMessageService
        extends RabbitTemplate.ConfirmCallback
{
    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param queueEnum 队列配置枚举
     * @throws Exception
     */
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;
}