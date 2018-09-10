package com.gbai;

import com.gbai.entity.MessageEntity;
import com.gbai.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-09-10 11:46
 **/
@RestController
public class TestController {

    /**
     * 消息队列 - 消息提供者 注入
     */
    @Autowired
    private MessageProvider messageProvider;

    /**
     * 测试发送消息队列方法
     *
     * @param messageEntity 发送消息实体内容
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(MessageEntity messageEntity) {
        // 将实体实例写入消息队列
        messageProvider.sendMessage(messageEntity);
        return "Success";
    }

}
