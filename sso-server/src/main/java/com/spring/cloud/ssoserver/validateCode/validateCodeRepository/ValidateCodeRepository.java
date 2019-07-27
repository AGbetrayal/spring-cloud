package com.spring.cloud.ssoserver.validateCode.validateCodeRepository;

import com.spring.cloud.ssoserver.validateCode.validateCodeEntry.ValidateCode;
import com.spring.cloud.ssoserver.validateCode.validateCodeType.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码存取器
 * @author AGbetrayal
 * @date 2019/7/27 10:50
 */
public interface ValidateCodeRepository {
    /**
     * 保存验证码
     * @param request
     * @param code
     * @param validateCodeType
     */
    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);
    /**
     * 获取验证码
     * @param request
     * @param validateCodeType
     * @return
     */
    ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);
    /**
     * 移除验证码
     * @param request
     * @param codeType
     */
    void remove(ServletWebRequest request, ValidateCodeType codeType);
}
