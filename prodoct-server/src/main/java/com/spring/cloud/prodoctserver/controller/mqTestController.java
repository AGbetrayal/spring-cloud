package com.spring.cloud.prodoctserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author AGbetrayal
 * @date 2019/9/20 14:35
 */
@Component
public class mqTestController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void sendMq(){
        jmsMessagingTemplate.convertAndSend(queue, "**************");
    }


    public void cummer(){}

}
