package com.spring.cloud.ssoserver.validateCode;

import com.spring.cloud.ssoserver.send.DefaultSmsCodeSender;
import com.spring.cloud.ssoserver.send.SmsCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 *   模块默认的配置。
 * @author AGbetrayal
 * @date 2019/7/27 11:41
 */
@Configuration
public class ValidateCodeBeanConfig {
    /**
     * 短信验证码发送器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
