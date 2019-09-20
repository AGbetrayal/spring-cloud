package com.spring.cloud.orderserver.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author AGbetrayal
 * @date 2019/9/20 15:01
 */
@Component
public class mqCus {

    @JmsListener(destination = "${queueStrName}")
    public void receive(TextMessage text) throws JMSException {
        System.out.println( "QueueListener: consumer-a 收到一条信息: " + text.getText() );
    }
}
