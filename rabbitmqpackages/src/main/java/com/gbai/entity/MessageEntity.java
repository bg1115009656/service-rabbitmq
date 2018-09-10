package com.gbai.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:33
 **/
@Data
public class MessageEntity implements Serializable {

    private String contents;
}
