package com.gbai.user;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-08-03 14:48
 **/
@Component
@RabbitListener(queues = "user.register.queue")
public class UserConsumer {

    @RabbitHandler
    public void execute(Long userId)
    {
        System.out.println("用户：" + userId+"，完成了注册");

        //...//自行业务逻辑处理
    }
}
