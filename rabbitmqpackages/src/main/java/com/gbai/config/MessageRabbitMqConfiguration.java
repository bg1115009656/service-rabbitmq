package com.gbai.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:00
 **/
@Configuration
public class MessageRabbitMqConfiguration {

    /**
     * 构建交换器实例
     * @return
     */
    @Bean
    public DirectExchange messageDirectExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueConstants.MESSAGE_EXCHANGE).durable(true).build();
    }

    /**
     * 构建队列实例
     * @return
     */
    @Bean
    public Queue messageQueue(){
        return QueueBuilder.durable(QueueConstants.MESSAGE_QUEUE_NAME).build();
    }

    /**
     * 将队列注册进交换器
     * @return
     */
    @Bean
    public Binding messageBinding(){
        return BindingBuilder.bind(messageQueue()).to(messageDirectExchange()).with(QueueConstants.MESSAGE_ROUTE_KEY);

    }

}
