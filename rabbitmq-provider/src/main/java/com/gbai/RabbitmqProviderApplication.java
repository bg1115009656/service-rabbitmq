package com.gbai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqProviderApplication {
    static Logger logger = LoggerFactory.getLogger(RabbitmqProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
        logger.info("【【【【【消息队列-消息提供者启动成功.】】】】】");
    }
}
