package com.gbai.consumer;

import com.alibaba.fastjson.JSON;
import com.gbai.config.QueueConstants;
import com.gbai.entity.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:34
 **/
@Component
@RabbitListener(queues = QueueConstants.MESSAGE_QUEUE_NAME)
public class MessageConsumer {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitHandler
    public void handler(@Payload MessageEntity messageEntity) {
        logger.info("消费内容：{}", JSON.toJSONString(messageEntity));
    }
}
