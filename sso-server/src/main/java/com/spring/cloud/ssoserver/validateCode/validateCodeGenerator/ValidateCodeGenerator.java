package com.spring.cloud.ssoserver.validateCode.validateCodeGenerator;

import com.spring.cloud.ssoserver.validateCode.validateCodeEntry.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 * @author AGbetrayal
 * @date 2019/7/27 10:39
 */
public interface ValidateCodeGenerator {
    /**
     * 生成校验码
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
