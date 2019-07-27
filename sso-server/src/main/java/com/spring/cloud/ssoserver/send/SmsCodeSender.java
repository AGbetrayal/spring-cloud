package com.spring.cloud.ssoserver.send;

/**
 * @author AGbetrayal
 * @date 2019/7/27 11:10
 */
public interface SmsCodeSender {

    /**
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
