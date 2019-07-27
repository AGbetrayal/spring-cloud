package com.spring.cloud.ssoserver.validateCode;

import com.spring.cloud.ssoserver.validateCode.validateCodeEntry.ValidateCode;
import com.spring.cloud.ssoserver.validateCode.validateCodeGenerator.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 * @author AGbetrayal
 * @date 2019/7/27 10:42
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.imooc.security.core.validate.code.ValidateCodeGenerator#generate(org.
     * springframework.web.context.request.ServletWebRequest)
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(6);   //验证码长度
        return new ValidateCode(code, 60);                //验证码有效期
    }

}
