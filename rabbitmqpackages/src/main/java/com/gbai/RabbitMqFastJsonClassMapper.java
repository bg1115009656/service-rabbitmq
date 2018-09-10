package com.gbai;

import org.springframework.amqp.support.converter.DefaultClassMapper;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 14:23
 **/
public class RabbitMqFastJsonClassMapper extends DefaultClassMapper {

    public RabbitMqFastJsonClassMapper(){
        super();
        setTrustedPackages("*");
    }
}
