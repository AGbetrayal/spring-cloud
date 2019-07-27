package com.spring.cloud.ssoserver.validateCode.validateCodeException;

import org.springframework.security.core.AuthenticationException;

/**
 * @author AGbetrayal
 * @date 2019/7/27 11:16
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     *
     */
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
