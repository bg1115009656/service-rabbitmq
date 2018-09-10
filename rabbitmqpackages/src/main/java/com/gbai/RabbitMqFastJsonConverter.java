package com.gbai;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:58
 **/
public class RabbitMqFastJsonConverter extends AbstractMessageConverter {

    /**
     * 日志对象实例
     */
    private Logger logger = LoggerFactory.getLogger(RabbitMqFastJsonConverter.class);
    /**
     * 消息类型映射对象
     */
    private static ClassMapper classMapper = new RabbitMqFastJsonClassMapper();
    /**
     * 默认字符集
     */
    private static String DEFAULT_CHART_SET = "UTF-8";


    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        byte[] bytes = null;
        try {
            String jsonString = JSON.toJSONString(o);
            bytes = jsonString.getBytes(DEFAULT_CHART_SET);
        } catch (IOException e) {
            throw new MessageConversionException(
                    "Failed to convert Message content", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(DEFAULT_CHART_SET);
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }
        classMapper.fromClass(o.getClass(), messageProperties);
        return new Message(bytes, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        Object content = null;
        MessageProperties properties = message.getMessageProperties();
        if (properties != null) {
            String contentType = properties.getContentType();
            if (contentType != null && contentType.contains("json")) {
                String encoding = properties.getContentEncoding();
                if (encoding == null) {
                    encoding = DEFAULT_CHART_SET;
                }
                try {
                    Class<?> targetClass = classMapper.toClass(
                            message.getMessageProperties());

                    content = convertBytesToObject(message.getBody(),
                            encoding, targetClass);
                } catch (IOException e) {
                    throw new MessageConversionException(
                            "Failed to convert Message content", e);
                }
            } else {
                logger.warn("Could not convert incoming message with content-type ["
                        + contentType + "]");
            }
        }
        if (content == null) {
            content = message.getBody();
        }
        return content;
    }

    /**
     * 将字节数组转换成实例对象
     *
     * @param body     Message对象主体字节数组
     * @param encoding 字符集
     * @param clazz    类型
     * @return
     * @throws UnsupportedEncodingException
     */
    private Object convertBytesToObject(byte[] body, String encoding,
                                        Class<?> clazz) throws UnsupportedEncodingException {
        String contentAsString = new String(body, encoding);
        return JSON.parseObject(contentAsString, clazz);
    }

}
