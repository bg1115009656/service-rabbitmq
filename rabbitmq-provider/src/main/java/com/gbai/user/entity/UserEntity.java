package com.gbai.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: service-rabbitmq
 * @description:
 * @author: gbai
 * @create: 2018-08-03 14:09
 **/
@Data
@Table(name = "user_info")
@Entity
public class UserEntity
        implements Serializable
{
    /**
     * 用户编号
     */
    @Id
    @GeneratedValue
    @Column(name = "UI_ID")
    protected Long id;
    /**
     * 用户名称
     */
    @Column(name = "UI_USER_NAME")
    private String userName;
    /**
     * 姓名
     */
    @Column(name = "UI_NAME")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "UI_AGE")
    private int age;
    /**
     * 余额
     */
    @Column(name = "UI_BALANCE")
    private BigDecimal balance;
}
