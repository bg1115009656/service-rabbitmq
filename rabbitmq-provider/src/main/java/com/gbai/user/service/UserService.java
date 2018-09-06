package com.gbai.user.service;

import com.gbai.enums.ExchangeEnum;
import com.gbai.enums.QueueEnum;
import com.gbai.rabbitmq.QueueMessageService;
import com.gbai.user.entity.UserEntity;
import com.gbai.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-08-03 14:20
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    /**
     * 消息队列业务逻辑实现
     */
    @Autowired
    private QueueMessageService queueMessageService;

    /**
     * 保存用户
     * 并写入消息队列
     * @param userEntity
     * @return
     */
    public Long save(UserEntity userEntity) throws Exception
    {
        /**
         * 保存用户
         */
        userRepository.save(userEntity);
        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(userEntity.getId(), ExchangeEnum.USER_REGISTER, QueueEnum.USER_REGISTER);

        return userEntity.getId();
    }

    public void delete(Long id) throws Exception
    {
        /**
         * 保存用户
         */
        userRepository.delete(id);
        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(id, ExchangeEnum.USER_REGISTER, QueueEnum.USER_DELETE);

    }
}
