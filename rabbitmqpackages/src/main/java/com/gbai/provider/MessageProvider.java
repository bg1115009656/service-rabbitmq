package com.gbai.provider;

import com.alibaba.fastjson.JSON;
import com.gbai.config.QueueConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:34
 **/
@Component
public class MessageProvider {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageProvider.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object object) {
        logger.info("写入消息队列内容：{}", JSON.toJSONString(object));
        amqpTemplate.convertAndSend(QueueConstants.MESSAGE_EXCHANGE, QueueConstants.MESSAGE_ROUTE_KEY, object);
    }
}
