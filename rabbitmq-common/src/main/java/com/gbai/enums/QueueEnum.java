package com.gbai.enums;

import lombok.Getter;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-08-03 14:35
 **/
@Getter
public enum QueueEnum
{
    /**
     * 用户注册枚举
     */
    USER_REGISTER("user.register.queue","user.register"),
    USER_DELETE("user.delete.queue","user.delete");
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
