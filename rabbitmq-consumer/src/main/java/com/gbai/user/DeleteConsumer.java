package com.gbai.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-06 17:21
 **/
@Component
@RabbitListener(queues = "user.delete.queue")
public class DeleteConsumer {

    /**
     * logback
     */
    private Logger logger = LoggerFactory.getLogger(UserConsumer.class);

    @RabbitHandler
    public void execute(Long userId)
    {
        logger.info("用户注销消费者【节点2】获取消息，用户编号：{}",userId);

        //...//自行业务逻辑处理
    }
}
