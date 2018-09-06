package com.gbai.enums;

import lombok.Getter;

@Getter
public enum ExchangeEnum
{
    /**
     * 用户注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange");
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
