package com.spring.cloud.prodoctserver.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author AGbetrayal
 * @date 2019/9/20 14:23
 */
@Component
@EnableJms
public class MqConfig {

    @Value("${queueStrName}")
    private String queueStrName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueStrName);
    }
}
