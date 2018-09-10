package com.gbai.config;

import com.gbai.RabbitMqFastJsonConverter;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 14:06
 **/
@Configuration
public class RabbitMqConfiguration {

    /**
     * 配置消息队列模版
     * 并且设置MessageConverter为自定义FastJson转换器
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new RabbitMqFastJsonConverter());
        return template;
    }
    /**
     * 自定义队列容器工厂
     * 并且设置MessageConverter为自定义FastJson转换器
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setMessageConverter(new RabbitMqFastJsonConverter());
        containerFactory.setDefaultRequeueRejected(false);
        return containerFactory;
    }
}
